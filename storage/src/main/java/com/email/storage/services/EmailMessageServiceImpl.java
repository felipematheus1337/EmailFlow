package com.email.storage.services;

import com.email.storage.Domain.EmailMessage;
import com.email.storage.adapter.EmailMessageAdapter;
import com.email.storage.dto.EmailMessageRequest;
import com.email.storage.repositories.EmailMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailMessageServiceImpl implements EmailMessageService {

    private final EmailMessageRepository repository;
    private final EmailMessageAdapter emailMessageAdapter;

    public EmailMessageServiceImpl(EmailMessageRepository repository, EmailMessageAdapter adapter) {
        this.repository = repository;
        this.emailMessageAdapter = adapter;
    }

    @Override
    public void save(List<EmailMessageRequest> request) {

        List<EmailMessage> mails = this.emailMessageAdapter.adapt(request);

        if (!mails.isEmpty()) this.repository.saveAll(mails);
    }
}
