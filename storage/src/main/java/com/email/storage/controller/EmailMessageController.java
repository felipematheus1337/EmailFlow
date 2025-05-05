package com.email.storage.controller;

import com.email.storage.dto.EmailMessageRequest;
import com.email.storage.services.EmailMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmailMessageController {

    private final EmailMessageService service;

    public EmailMessageController(EmailMessageService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody List<EmailMessageRequest> request) {

        this.service.save(request);

        return ResponseEntity.created(null).build();
    }


}
