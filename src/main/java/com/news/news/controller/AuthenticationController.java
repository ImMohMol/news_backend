package com.news.news.controller;

import com.news.news.model.AuthenticationResponse;
import com.news.news.model.dto.LoginDTO;
import com.news.news.model.dto.RegisterDTO;
import com.news.news.service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final IAuthenticationService authenticationService;

    @PostMapping(path = "/signIn")
    public ResponseEntity<AuthenticationResponse> signIn(@RequestBody RegisterDTO registerDTO) {
        return ResponseEntity.ok(this.authenticationService.signIn(registerDTO));
    }

    @GetMapping(path = "/login/{username}/{password}")
    public ResponseEntity<AuthenticationResponse> login(@PathVariable(name = "username") String username,
                                                        @PathVariable(name = "password") String password) {
        return ResponseEntity.ok(this.authenticationService.login(new LoginDTO(username, password)));
    }
}
