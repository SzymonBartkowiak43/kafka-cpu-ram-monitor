package com.example.recommentationsms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestClient;


import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class RecommendationServiceTest {

    @Mock
    private RestClient.Builder restClientBuilder;

    @Mock
    private RestClient restClient;

    @Mock
    private RestClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private RestClient.ResponseSpec responseSpec;

    private RecommendationService recommendationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recommendationService = new RecommendationService(restClientBuilder);
        when(restClientBuilder.build()).thenReturn(restClient);

        when(restClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.<Object[]>any()
                )).thenReturn(requestHeadersUriSpec);

        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
    }

    @Test
    void shouldReturnListOfRecommendationWhenTagIsProvided() {
        //given
        List<Map<String, String>> mockResponse = List.of(
                Map.of("id", "1", "title", "Architektit.pl", "tag", "java")
        );
        when(responseSpec.body(List.class)).thenReturn(mockResponse);

        //when
        List<Map<String, String>> result = recommendationService.getRecommendationsByTag("java");

        //then
        assertEquals(1, result.size());
        assertEquals("Architektit.pl", result.get(0).get("title"));
    }



}