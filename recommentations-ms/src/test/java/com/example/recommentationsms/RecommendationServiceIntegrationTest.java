package com.example.recommentationsms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestToUriTemplate;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest(classes = {RecommendationService.class, Config.class})
class RecommendationServiceIntegrationTest {

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private RestClient.Builder restClientBuilder;

    private MockRestServiceServer mockServer;

    @BeforeEach
    void setUp() {
       mockServer = MockRestServiceServer.bindTo(restClientBuilder).build();

    }

    @Test
    void shouldCallApiAndReturnListOfRecommendationWhenTagIsProvided() {
        //given
        String mockResponse = "[{\"id\":1,\"title\":\"Architektit.pl\",\"tag\":\"java\"}]";

        this.mockServer
                .expect(requestToUriTemplate("http://localhost:8080/api/content/{tag}", "java"))
                .andExpect(method((GET)))
                .andRespond(withSuccess(mockResponse, MediaType.APPLICATION_JSON));

        //when
        List<Map<String, String>> result = recommendationService.getRecommendationsByTag("java");

        //then
        assertEquals(1, result.size());
        assertEquals("Architektit.pl", result.get(0).get("title"));

        mockServer.verify();
    }




}