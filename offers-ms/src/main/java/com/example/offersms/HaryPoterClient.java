package com.example.offersms;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
public class HaryPoterClient {

    private final RestClient restClient;

    public HaryPoterClient() {
        this.restClient = RestClient.builder().build();
    }

    @GetMapping("/haryPotter")
    public List<Character> callPoter() {
        return restClient.get()
                .uri("http://localhost:8080/api/characters")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

}
