package com.news.news.service.Impl;

import com.news.news.model.AuthenticationResponse;
import com.news.news.model.User;
import com.news.news.model.dto.CreateUserDTO;
import com.news.news.model.dto.LoginDTO;
import com.news.news.model.dto.RegisterDTO;
import com.news.news.repository.IUserRepository;
import com.news.news.service.IAuthenticationService;
import com.news.news.service.IJwtService;
import com.news.news.service.IPasswordService;
import com.news.news.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final IPasswordService passwordService;
    private final IUserRepository userRepository;
    private final IUserService userService;
    private final IJwtService jwtService;

    @Override
    public AuthenticationResponse signIn(RegisterDTO registerDTO) {
        CreateUserDTO createUserDTO = CreateUserDTO.builder()
                .firstName(registerDTO.getFirstName())
                .lastName(registerDTO.getLastName())
                .age(registerDTO.getAge())
                .username(registerDTO.getUsername())
                .password(this.passwordService.encodePassword(registerDTO.getPassword()))
                .build();
        User user = this.userService.add(createUserDTO);

        String jwtToken = this.jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse login(LoginDTO loginDTO) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
                loginDTO.getPassword()));
        User user = this.userService.findByUsername(loginDTO.getUsername());

        String jwtToken = this.jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
