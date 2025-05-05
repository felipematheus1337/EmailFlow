package com.email.flow.amqp;


import com.email.flow.dtos.EmailDispatchKafkaDTO;
import com.email.flow.repositories.SendLogRepository;
import com.email.flow.services.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailMessageListener {

    private final SendLogRepository repository;
    private final ObjectMapper mapper;
    private final EmailService service;

    EmailMessageListener(SendLogRepository repository, ObjectMapper mapper, EmailService service) {
        this.repository = repository;
        this.mapper = mapper;
        this.service = service;
    }

    @KafkaListener
    public void sendMails(@Payload String message) throws JsonProcessingException {
       List<EmailDispatchKafkaDTO> mails = mapper.readValue(message,
               new TypeReference<List<EmailDispatchKafkaDTO>>() {
       });

       this.service.send(mails);

    }
}
