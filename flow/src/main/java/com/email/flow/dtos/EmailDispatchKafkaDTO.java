package com.email.flow.dtos;

import java.io.Serializable;
import java.util.UUID;

public class EmailDispatchKafkaDTO implements Serializable {

    private UUID id;
    private String recipient;
    private String subject;
    private String body;

    public EmailDispatchKafkaDTO(UUID id, String recipient, String subject, String body) {
        this.id = id;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    public  UUID Id() {
        return id;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
