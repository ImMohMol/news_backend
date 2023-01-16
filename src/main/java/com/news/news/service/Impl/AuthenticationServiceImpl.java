package com.news.news.service.Impl;

import com.news.news.model.AuthenticationResponse;
import com.news.news.model.User;
import com.news.news.model.dto.LoginDTO;
import com.news.news.model.dto.RegisterDTO;
import com.news.news.repository.IUserRepository;
import com.news.news.service.IAuthenticationService;
import com.news.news.service.IJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final IUserRepository userRepository;
    private final IJwtService jwtService;

    @Override
    public AuthenticationResponse signIn(RegisterDTO registerDTO) {
        User user = User.builder()
                .firstName(registerDTO.getFirstName())
                .lastName(registerDTO.getLastName())
                .age(registerDTO.getAge())
                .username(registerDTO.getUsername())
                .password(this.passwordEncoder.encode(registerDTO.getPassword()))
                .build();

        this.userRepository.save(user);

        String jwtToken = this.jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse login(LoginDTO loginDTO) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
                loginDTO.getPassword()));
        User user = this.userRepository.findByUsername(loginDTO.getUsername()).orElseThrow();
        String jwtToken = this.jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
