package com.example.recommentationsms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<ContentFromRecommendation, Long> {

    List<ContentFromRecommendation> findByTagIgnoreCase(String tag);

}
