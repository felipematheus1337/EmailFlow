package com.email.flow.repositories;


import com.email.flow.domain.MailStatus;
import com.email.flow.domain.SendLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SendLogRepository extends JpaRepository<SendLog, UUID> {


    List<SendLog> findByStatus(MailStatus status);
}
