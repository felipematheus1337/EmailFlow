package com.email.flow.services;

import com.email.flow.adapter.EmailSendLogAdapter;
import com.email.flow.domain.MailStatus;
import com.email.flow.domain.SendLog;
import com.email.flow.dtos.EmailDispatchKafkaDTO;
import com.email.flow.dtos.EmailMessageDocument;
import com.email.flow.repositories.SendLogRepository;
import com.email.flow.utils.BusinessUtils;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements EmailService {

    private final SendLogRepository repository;
    private final JavaMailSender mailSender;
    private final BusinessUtils businessUtils;
    private final EmailSendLogAdapter emailSendLogAdapter;

    public EmailServiceImpl(SendLogRepository repository, JavaMailSender mailSender, BusinessUtils businessUtils, EmailSendLogAdapter emailSendLogAdapter) {
        this.repository = repository;
        this.mailSender = mailSender;
        this.businessUtils = businessUtils;
        this.emailSendLogAdapter = emailSendLogAdapter;
    }

    @Override
    public void send(List<EmailDispatchKafkaDTO> dtos) {

        List<UUID> mailIds = dtos.stream()
                .map(EmailDispatchKafkaDTO::Id)
                .collect(Collectors.toList());

        List<SendLog> mailsToSend = repository.findAllById(mailIds);

        List<CompletableFuture<Void>> futures = mailsToSend.stream()
                        .map(mail -> CompletableFuture.runAsync(() -> {
                            try {
                              sendTheMail(mail);
                              mail.setStatus(MailStatus.SENT);
                            } catch (Exception e) {
                                mail.setStatus(MailStatus.ERROR);
                            } finally {
                                mail.setAttemptedAt(LocalDateTime.now());
                            }
        })).collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

         var savedMails = repository.saveAll(mailsToSend);

         List<EmailMessageDocument> documents = this.emailSendLogAdapter.adapt(savedMails);


    }

    private void sendTheMail(SendLog mail) throws MailException, MessagingException {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(businessUtils.getMailHost());
        helper.setTo(mail.getTo());
        helper.setSubject(mail.getSubject());
        helper.setText(mail.getBody());
        mailSender.send(message);
    }
}
