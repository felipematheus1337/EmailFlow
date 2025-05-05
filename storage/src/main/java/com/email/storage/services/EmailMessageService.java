package com.email.storage.services;

import com.email.storage.dto.EmailMessageRequest;

import java.util.List;

public interface EmailMessageService {

    void save(List<EmailMessageRequest> request);
}
