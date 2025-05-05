package com.email.flow.services;

import com.email.flow.dtos.EmailDispatchKafkaDTO;

import java.util.List;

public interface EmailService {

    void send(List<EmailDispatchKafkaDTO> dtos);
}
