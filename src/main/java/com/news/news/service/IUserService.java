package com.news.news.service;

import com.news.news.model.User;
import com.news.news.model.dto.CreateUserDTO;

public interface IUserService {
    User add(CreateUserDTO createUserDTO);

    User findByUsername(String username);
}
