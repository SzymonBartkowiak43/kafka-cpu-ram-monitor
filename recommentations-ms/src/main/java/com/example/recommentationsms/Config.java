package com.example.recommentationsms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class Config {

    @Bean
    RestClient.Builder getRestClientBuilder() {
        return RestClient.builder();
    }

}
