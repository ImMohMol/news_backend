package com.news.news.repository;

import com.news.news.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface INewsRepository extends JpaRepository<News, Long> {
    Optional<News> findByTitle(String title);
}
