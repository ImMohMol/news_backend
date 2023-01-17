package com.news.news.service.Impl;

import com.news.news.model.Category;
import com.news.news.model.User;
import com.news.news.model.dto.CreateUserDTO;
import com.news.news.repository.IUserRepository;
import com.news.news.service.ICategoryService;
import com.news.news.service.IUserCategoryService;
import com.news.news.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserCategoryService userCategoryService;
    private final ICategoryService categoryService;
    private final IUserRepository userRepository;

    @Override
    public User add(CreateUserDTO createUserDTO) {
        User user = User.builder()
                .firstName(createUserDTO.getFirstName())
                .lastName(createUserDTO.getLastName())
                .age(createUserDTO.getAge())
                .username(createUserDTO.getUsername())
                .password(createUserDTO.getPassword())
                .selectedCategories(new HashSet<>())
                .build();
        this.userRepository.save(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username).orElseThrow();
    }

    @Override
    public Category selectCategory(String username, String categoryName) {
        User user = this.userRepository.findByUsername(username).orElseThrow();
        Category category = this.categoryService.findByName(categoryName);
        this.userCategoryService.addCategoryForUser(user, category);
        return category;
    }
}
