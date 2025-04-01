package com.example.contentclientms;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;


import java.util.Arrays;
import java.util.List;

@RestController
public class ContentClient {

    private final RestClient restClient;

    public ContentClient() {
        this.restClient = RestClient.builder().build();
    }

    @GetMapping("/call-client")
    @CircuitBreaker(name = "ContentClientCall", fallbackMethod = "fallbackMethodGetContent")
    public List<Content> callClient(@RequestParam String tag) {
        return restClient.get()
                .uri("http://localhost:8080/api/content/{tag}", tag)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    public List<Content> fallbackMethodGetContent(String tag, Throwable throwable) {
        return Arrays.asList(new Content(0L, "Fallback Content", "Fallback Tag"));
    }


}
