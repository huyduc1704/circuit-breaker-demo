package com.group6.user_service.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service

public class ProductClient {
    private final RestTemplate restTemplate;

    public ProductClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @CircuitBreaker(name = "userService", fallbackMethod = "fallbackProducts")
    public List<Object> getProducts() {
        String url = "http://localhost:9191/products";
        return restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Object>>() {}).getBody();
    }

    public List<Object> fallbackProducts(Throwable t) {
        return List.of(
                Map.of("id", 0, "name", "Mock Product", "price", 0, "stock", 0, "category", "N/A")
        );
    }
}
