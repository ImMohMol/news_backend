package com.news.news.repository;

import com.news.news.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INewsRepository extends JpaRepository<News, Long> {
}
