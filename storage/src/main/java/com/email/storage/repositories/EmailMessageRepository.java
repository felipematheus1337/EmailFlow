package com.email.storage.repositories;

import com.email.storage.Domain.EmailMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailMessageRepository extends MongoRepository<EmailMessage, String> {
}
