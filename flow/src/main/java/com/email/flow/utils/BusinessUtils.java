package com.email.flow.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BusinessUtils {

    public static final String TOPIC_NAME = "mail";

    @Value("${spring.mail.host}")
    private String mailHost;

    public String getMailHost() {
        return mailHost;

    }
}
