package com.email.flow.services;

import com.email.flow.dtos.EmailMessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Override
    public void publishEmails(List<EmailMessageDTO> mails) {

    }
}
