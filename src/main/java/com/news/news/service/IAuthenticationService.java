package com.news.news.service;

import com.news.news.model.AuthenticationResponse;
import com.news.news.model.dto.RegisterDTO;

public interface IAuthenticationService {
    public AuthenticationResponse signIn(RegisterDTO registerDTO);
}
