package com.email.flow.dtos;

import java.io.Serializable;

public class EmailDispatchKafkaDTO implements Serializable {

    private Long id;
    private String recipient;
    private String subject;
    private String body;

    public EmailDispatchKafkaDTO(Long id, String recipient, String subject, String body) {
        this.id = id;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    public Long getId() {
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
