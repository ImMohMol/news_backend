package com.news.news.service;

import com.news.news.model.Category;
import com.news.news.model.User;
import com.news.news.model.UserSelectedCategories;

public interface IUserCategoryService {
    UserSelectedCategories addCategoryForUser(User user, Category category);
}
