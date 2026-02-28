package com.example.tandapp.auth.infrastructure.adapters;

import com.example.tandapp.auth.domain.Users;
import com.example.tandapp.auth.domain.ports.out.IAccessTokenMaker;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AccessTokenMakerImpl implements IAccessTokenMaker {

    @Value("{jwt.secret}")
    private final String secret;

    @Value("${jwt.expiration}")
    private final Long expiration;

    public AccessTokenMakerImpl(
            @Value("{jwt.secret}") String secret,
            @Value("${jwt.expiration}") Long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    @Override
    public String generateAccessToken(Users user){
        return Jwts.builder()
                .setSubject(user.getInformation().getEmail())
                .claim("userId", user.showId().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
}
