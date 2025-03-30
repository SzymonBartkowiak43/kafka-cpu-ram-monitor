package com.example.recommentationsms;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class RecommendationService {


    private final RestClient.Builder builder;

    public RecommendationService(RestClient.Builder builder) {
        this.builder = builder;
    }

    public List<Map<String, String>> getRecommendationsByTag(String tag) {
        return builder.build()
                .get()
                .uri("http://localhost:8080/api/content/{tag}", tag)
                .retrieve()
                .body(List.class);
    }
}
