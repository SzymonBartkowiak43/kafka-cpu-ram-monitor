package com.example.recommentationsms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class RecommendationService {

    @Autowired
    private RestClient.Builder builder;

    public List<Map<String, String>> getRecommendationsByTag(String tag) {
        return builder.build()
                .get()
                .uri("http://localhost:61295/api/content/{tag}", tag)
                .retrieve()
                .body(List.class);
    }
}
