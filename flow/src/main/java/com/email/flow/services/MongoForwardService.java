package com.email.flow.services;

import com.email.flow.dtos.EmailMessageDocument;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface MongoForwardService {

    void send(List<EmailMessageDocument> documents) throws JsonProcessingException;
}
