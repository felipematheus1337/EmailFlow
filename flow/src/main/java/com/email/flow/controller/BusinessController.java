package com.email.flow.controller;

import com.email.flow.dtos.EmailMessageDTO;
import com.email.flow.services.BusinessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BusinessController {

    private final BusinessService service;

    BusinessController(BusinessService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> sendMails(@RequestBody List<EmailMessageDTO> dtos) {
        this.service.publishEmails(dtos);

        return ResponseEntity.noContent().build();
    }
}
