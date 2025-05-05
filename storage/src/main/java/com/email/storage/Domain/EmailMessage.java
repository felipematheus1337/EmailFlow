package com.email.storage.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "emails")
public class EmailMessage {

    @Id
    private String id;

    private String sendLogId;

    private String to;

    private String subject;

    private String body;

    private String status;

    private LocalDateTime savedTime = LocalDateTime.now();

    public EmailMessage(String sendLogId, String to, String subject, String body, String status) {
        this.sendLogId = sendLogId;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.status = status;
    }

    public LocalDateTime getSavedTime() {
        return savedTime;
    }

    public void setSavedTime(LocalDateTime savedTime) {
        this.savedTime = savedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSendLogId() {
        return sendLogId;
    }

    public void setSendLogId(String sendLogId) {
        this.sendLogId = sendLogId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
