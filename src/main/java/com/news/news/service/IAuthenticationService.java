package com.news.news.service;

import com.news.news.model.AuthenticationResponse;
import com.news.news.model.dto.LoginDTO;
import com.news.news.model.dto.RegisterDTO;

public interface IAuthenticationService {
    AuthenticationResponse signIn(RegisterDTO registerDTO);

    AuthenticationResponse login(LoginDTO loginDTO);
}
