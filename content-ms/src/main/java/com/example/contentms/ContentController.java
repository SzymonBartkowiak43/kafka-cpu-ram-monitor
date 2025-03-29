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

    private List<Map<String, String>> contentList = List.of(
            Map.of("id", "1", "title", "AkademiaSpringa.pl", "tag", "spring"),
            Map.of("id", "2", "title", "ArchitektIT.pl", "tag", "cloud")
    );


    @GetMapping
    public List<Map<String, String>> getContent() {
        return contentList;
    }

    @GetMapping("/{tag}")
    public List<Map<String, String>> getContentByTag(@PathVariable String tag) {
        return contentList.stream()
                .filter(content -> content.get("tag").equalsIgnoreCase(tag))
                .toList();
    }


}
