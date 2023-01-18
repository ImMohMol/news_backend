package com.news.news.service.Impl;

import com.news.news.model.Category;
import com.news.news.repository.ICategoryRepository;
import com.news.news.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    @Override
    public Category add(String name) {
        Category category = Category.builder()
                .name(name)
                .user(new HashSet<>())
                .build();
        return this.categoryRepository.save(category);
    }

    @Override
    public Category findByName(String name) {
        return this.categoryRepository.findByName(name).orElseThrow();
    }
}
