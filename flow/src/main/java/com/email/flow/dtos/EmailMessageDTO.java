package com.email.flow.dtos;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class EmailMessageDTO {

    @NotNull
    private String to;
    @NotNull
    @Length(min = 3, max = 120)
    private String subject;
    @NotNull
    private String body;
    private LocalDateTime sendDate = LocalDateTime.now();

    public EmailMessageDTO(String to, String subject, String body, LocalDateTime sendDate) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.sendDate = sendDate;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }
}
