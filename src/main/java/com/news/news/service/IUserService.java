package com.news.news.service;

import com.news.news.model.Category;
import com.news.news.model.User;
import com.news.news.model.dto.CreateUserDTO;
import com.news.news.model.dto.SelectMultipleCategoriesDTO;

public interface IUserService {
    User add(CreateUserDTO createUserDTO);

    User findByUsername(String username);

    Category selectCategory(String username, String categoryName);

    boolean selectMultipleCategoriesForUser(String username, SelectMultipleCategoriesDTO categoriesDTO);
}
