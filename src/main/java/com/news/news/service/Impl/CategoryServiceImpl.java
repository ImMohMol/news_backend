package com.news.news.service.Impl;

import com.news.news.model.Category;
import com.news.news.repository.ICategoryRepository;
import com.news.news.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    @Override
    public Category findByName(String name) {
        return this.categoryRepository.findByName(name).orElseThrow();
    }
}
