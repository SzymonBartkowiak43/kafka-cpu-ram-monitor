package com.example.contentms;


import jakarta.persistence.*;

@Entity
@Table(name = "contents")
public class Content {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String tag;

    public Content() {
    }

    public Content(Long id, String title, String tag) {
        this.id = id;
        this.title = title;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }
}
