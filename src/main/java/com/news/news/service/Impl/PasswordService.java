package com.news.news.service.Impl;

import com.news.news.service.IPasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordService implements IPasswordService {
    private final PasswordEncoder passwordEncoder;


    @Override
    public String encodePassword(String password) {
        return this.passwordEncoder.encode(password);
    }
}
