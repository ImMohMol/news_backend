package com.news.news.service.Impl;

import com.news.news.model.User;
import com.news.news.service.IJwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements IJwtService {
    private final static String SECRET_KEY = "2KJ2L87PzGW16sF+Cdt/3aneLJ266RfLp1t0OY+BngX/l1sOriWuSOcXyv7FoiYQJYh2" +
            "MCzvuusN6zmi4cQi0SPY4yHM084OirIe4uhYhDJEDYdDcJWGTGSkwQ1jgF6sZSB6YA==";

    @Override
    public String generateToken(User user) {
        return this.generateToken(new HashMap<>(), user);
    }

    @Override
    public String generateToken(Map<String, Object> extraClaims, User user) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1_000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public Claims extractAllClaims(String jwtToken) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey()).build()
                .parseClaimsJws(jwtToken).getBody();
    }

    @Override
    public <T> T extractClaim(String jwtToken, Function<Claims, T> claimResolver) {
        final Claims allClaims = this.extractAllClaims(jwtToken);
        return claimResolver.apply(allClaims);
    }

    @Override
    public String extractUserName(String jwtToken) {
        return this.extractClaim(jwtToken, Claims::getSubject);
    }

    @Override
    public boolean isTokenValid(String jwtToken, User user) {
        final String username = this.extractUserName(jwtToken);
        return (username.equals(user.getUsername()) && !isTokenExpired(jwtToken));
    }

    @Override
    public boolean isTokenExpired(String jwtToken) {
        return this.extractExpiration(jwtToken).before(new Date());
    }

    @Override
    public Date extractExpiration(String jwtToken) {
        return this.extractClaim(jwtToken, Claims::getExpiration);
    }
}
