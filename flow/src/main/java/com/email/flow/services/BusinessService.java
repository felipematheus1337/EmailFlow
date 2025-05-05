package com.email.flow.services;

import com.email.flow.dtos.EmailMessageDTO;

import java.util.List;

public interface BusinessService {

    void publishEmails(List<EmailMessageDTO> mails);
}
