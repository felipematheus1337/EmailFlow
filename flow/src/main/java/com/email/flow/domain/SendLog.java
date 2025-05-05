package com.email.flow.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class SendLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String to;
    private String subject;
    private LocalDateTime attemptedAt;
    private MailStatus status;
    private String body;

    public SendLog(String to, String subject, LocalDateTime attemptedAt, MailStatus status, String body) {
        this.to = to;
        this.subject = subject;
        this.attemptedAt = attemptedAt;
        this.status = status;
        this.body = body;
    }

    public UUID getId() {
        return id;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDateTime getAttemptedAt() {
        return attemptedAt;
    }

    public MailStatus getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }
}
