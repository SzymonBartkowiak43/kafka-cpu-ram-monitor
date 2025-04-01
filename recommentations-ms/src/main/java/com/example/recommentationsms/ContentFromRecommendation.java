package com.example.recommentationsms;


import jakarta.persistence.*;

@Entity
@Table(name = "contents_from_recommendations")
public class ContentFromRecommendation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String tag;

    public ContentFromRecommendation() {
    }

    public ContentFromRecommendation(Long id, String title, String tag) {
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
