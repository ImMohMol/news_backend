package com.news.news.service.Impl;

import com.news.news.model.Category;
import com.news.news.model.User;
import com.news.news.model.UserSelectedCategories;
import com.news.news.repository.IUserCategoryRepository;
import com.news.news.service.IUserCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCategoryServiceImpl implements IUserCategoryService {
    private final IUserCategoryRepository userCategoryRepository;

    @Override
    public UserSelectedCategories addCategoryForUser(User user, Category category) {
        UserSelectedCategories userSelectedCategories = new UserSelectedCategories();
        userSelectedCategories.setUser(user);
        userSelectedCategories.setSelectedCategory(category);
        return this.userCategoryRepository.save(userSelectedCategories);
    }
}
