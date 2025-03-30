package com.example.contentms;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentRepository contentRepository;

    public ContentController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @GetMapping
    public List<Content> getContent() {
        return contentRepository.findAll();
    }

    @GetMapping("/{tag}")
    public List<Content> getContentByTag(@PathVariable String tag) {
        return contentRepository.findByTagIgnoreCase(tag);
    }

}
