package com.email.flow.dtos;

import com.email.flow.domain.MailStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class EmailMessageDocument implements Serializable {

    @JsonProperty(required = true)
    private String sendLogId;

    @JsonProperty(required = true)
    private String to;

    @JsonProperty(required = true)
    private String subject;

    @JsonProperty(required = true)
    private String body;

    @JsonProperty(required = true)
    private String status;

    public EmailMessageDocument(String sendLogId, String to, String subject, String body, String status) {
        this.sendLogId = sendLogId;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.status = status;
    }
}
