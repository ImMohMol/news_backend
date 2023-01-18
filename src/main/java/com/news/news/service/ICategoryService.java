package com.news.news.service;

import com.news.news.model.Category;

public interface ICategoryService {
    Category add(String name);
    Category findByName(String name);
}
