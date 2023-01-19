package com.news.news.service.Impl;

import com.news.news.model.Category;
import com.news.news.model.News;
import com.news.news.model.dto.CreateNewsDTO;
import com.news.news.model.dto.UpdateNewsDTO;
import com.news.news.repository.INewsRepository;
import com.news.news.service.ICategoryService;
import com.news.news.service.INewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements INewService {
    private final INewsRepository newsRepository;
    private final ICategoryService categoryService;

    @Override
    public News add(CreateNewsDTO createNewsDTO) {
        Category category = this.categoryService.findByName(createNewsDTO.getCategoryName());
        News news = News.builder()
                .title(createNewsDTO.getTitle())
                .body(createNewsDTO.getBody())
                .category(category)
                .numberOfVisits(0L)
                .build();

        return this.newsRepository.save(news);
    }

    @Override
    public boolean update(UpdateNewsDTO updateNewsDTO) {
        News news = this.newsRepository.findByTitle(updateNewsDTO.getTitle()).orElseThrow();
        Category category = this.categoryService.findByName(updateNewsDTO.getCategoryName());
        news.setTitle(updateNewsDTO.getTitle());
        news.setBody(updateNewsDTO.getBody());
        news.setCategory(category);
        news.setNumberOfVisits(updateNewsDTO.getNumberOfVisits());
        this.newsRepository.save(news);

        return true;
    }

    @Override
    public News deleteDTO(String title) {
        News news = this.newsRepository.findByTitle(title).orElseThrow();
        this.newsRepository.delete(news);

        return news;
    }

    @Override
    public List<News> getAll() {
        return this.newsRepository.findAll();
    }
}
