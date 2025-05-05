package com.email.flow.services;

import com.email.flow.domain.MailStatus;
import com.email.flow.domain.SendLog;
import com.email.flow.dtos.EmailDispatchKafkaDTO;
import com.email.flow.dtos.EmailMessageDTO;
import com.email.flow.repositories.SendLogRepository;
import com.email.flow.utils.BusinessUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    private final SendLogRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    BusinessServiceImpl(SendLogRepository repository, KafkaTemplate kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishEmails(List<EmailMessageDTO> mails) {

        List<SendLog> mailsToSave = mails.stream()
                .map(m ->
                        new SendLog(m.getTo(), m.getSubject(), m.getSendDate(), MailStatus.PENDING, m.getBody()))
                .toList();

        var mailsPending =  this.repository.saveAll(mailsToSave);

        List<EmailDispatchKafkaDTO> mailsToDispatch = mailsPending.stream()
                .map(md -> new EmailDispatchKafkaDTO(md.getId(), md.getTo(), md.getSubject(), md.getBody()))
                .toList();

        this.kafkaTemplate.send(BusinessUtils.TOPIC_NAME, mailsToDispatch);
    }
}
