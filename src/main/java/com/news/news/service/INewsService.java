package com.news.news.service;

import com.news.news.model.News;
import com.news.news.model.dto.CreateNewsDTO;
import com.news.news.model.dto.UpdateNewsDTO;

import java.util.List;

public interface INewsService {
    News add(CreateNewsDTO createNewsDTO);

    boolean update(UpdateNewsDTO updateNewsDTO);

    News delete(String title);

    List<News> getAll();
}
