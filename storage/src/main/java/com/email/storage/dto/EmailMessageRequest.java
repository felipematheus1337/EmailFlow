package com.email.storage.dto;

public class EmailMessageRequest {

    private String sendLogId;

    private String to;

    private String subject;

    private String body;

    private String status;


    public String getSendLogId() {
        return sendLogId;
    }

    public void setSendLogId(String sendLogId) {
        this.sendLogId = sendLogId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
