package com.email.flow.adapter;


import com.email.flow.domain.SendLog;
import com.email.flow.dtos.EmailMessageDocument;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmailSendLogAdapter {

    public List<EmailMessageDocument> adapt(List<SendLog> list) {

       return list.stream()
                .map(this::adaptSendLogToEmailMessageDocument)
                .toList();
    }

    private EmailMessageDocument adaptSendLogToEmailMessageDocument(SendLog sendLog) {

        return new EmailMessageDocument(sendLog.getId().toString(),
                sendLog.getTo(), sendLog.getSubject(), sendLog.getBody(), sendLog.getStatus());
    }
}
