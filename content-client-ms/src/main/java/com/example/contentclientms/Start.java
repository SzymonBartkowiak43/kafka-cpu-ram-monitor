package com.example.contentclientms;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class Start {

    private final PostsClient postsClient;

    public Start(PostsClient postsClient) {
        this.postsClient = postsClient;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        System.out.println(postsClient.getPost(1L));
    }
}
