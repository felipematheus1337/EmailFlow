package com.email.flow.scheduled;

import com.email.flow.domain.MailStatus;
import com.email.flow.domain.SendLog;
import com.email.flow.dtos.EmailDispatchKafkaDTO;
import com.email.flow.repositories.SendLogRepository;
import com.email.flow.services.EmailService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailLogScheduled {

    private final SendLogRepository repository;
    private final EmailService service;

    public EmailLogScheduled(SendLogRepository repository, EmailService service) {
        this.repository = repository;
        this.service = service;
    }

    @Scheduled(cron = "0 0 */3 * * *")
    public void retryFailedEmails() {
      List<SendLog> failedDTO = repository.findByStatus(MailStatus.ERROR);

      var emailsToDispatch = failedDTO.stream()
              .map(s -> new EmailDispatchKafkaDTO(s.getId(), s.getTo(), s.getSubject(), s.getBody()))
              .toList();

      service.send(emailsToDispatch);

    }
}
