package com.email.storage.adapter;

import com.email.storage.Domain.EmailMessage;
import com.email.storage.dto.EmailMessageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailMessageAdapter {

    public List<EmailMessage> adapt(List<EmailMessageRequest> request) {
        return request.stream()
                .map(this::toEntity)
                .toList();
    }

    private EmailMessage toEntity(EmailMessageRequest request) {
        return new EmailMessage(request.getSendLogId(), request.getTo(),
                request.getSubject(), request.getBody(), request.getStatus());
    }
}
