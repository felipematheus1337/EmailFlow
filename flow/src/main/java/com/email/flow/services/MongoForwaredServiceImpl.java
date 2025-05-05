package com.email.flow.services;

import com.email.flow.dtos.EmailMessageDocument;
import com.email.flow.utils.BusinessUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class MongoForwaredServiceImpl implements MongoForwardService {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void send(List<EmailMessageDocument> documents) throws JsonProcessingException {

        String json = objectMapper.writeValueAsString(documents);
        String url = BusinessUtils.URI_MONGO_MONOLITH + "save";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpClient.newHttpClient()
                .sendAsync(request, HttpResponse.BodyHandlers.discarding())
                .thenAccept(response -> {
                    System.out.println("Enviado!");
                }).exceptionally(e -> {
                    System.out.println("Error: " + e.getMessage());
                    return null;
                });

    }
}
