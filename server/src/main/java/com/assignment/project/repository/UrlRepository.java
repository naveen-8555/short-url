package com.assignment.project.repository;

import com.assignment.project.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url,Integer> {

    @Query(value = "select * from Url where short_url = ?1", nativeQuery = true)
    Optional<Url> findByShortUrl(String id);

}
