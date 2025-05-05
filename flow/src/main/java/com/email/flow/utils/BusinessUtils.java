package com.email.flow.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BusinessUtils {

    public static final String TOPIC_NAME = "mail";
    public static final String GROUP_ID = "mailgroup";
    public static final String URI_MONGO_MONOLITH = "http://localhost:8081/api/v1/";

    @Value("${spring.mail.host}")
    private String mailHost;

    public String getMailHost() {
        return mailHost;
    }
}
