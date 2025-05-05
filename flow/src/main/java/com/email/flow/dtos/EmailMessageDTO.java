package com.email.flow.dtos;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class EmailMessageDTO {

    @NotNull
    private String to;
    @NotNull
    @Length(min = 3, max = 120)
    private String subject;
    @NotNull
    private String body;
    private LocalDateTime sendDate;
}
