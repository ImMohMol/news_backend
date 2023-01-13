package com.news.news.service;

import com.news.news.model.User;
import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {
    String generateToken(User user);

    String generateToken(Map<String, Object> extraClaims, User user);

    Key getSignInKey();

    Claims extractAllClaims(String jwtToken);

    <T> T extractClaim(String jwtToken, Function<Claims, T> claimResolver);

    String extractUserName(String jwtToken);

    boolean isTokenValid(String jwtToken, User user);

    boolean isTokenExpired(String jwtToken);

    Date extractExpiration(String jwtToken);
}
