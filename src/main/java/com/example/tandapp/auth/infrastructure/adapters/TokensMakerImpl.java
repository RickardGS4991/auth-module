package com.example.tandapp.auth.infrastructure.adapters;

import com.example.tandapp.auth.domain.Users;
import com.example.tandapp.auth.domain.ports.out.ITokensMaker;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class TokensMakerImpl implements ITokensMaker {

    @Value("{jwt.secret}")
    private String secret;

    public String generateRefreshToken(){
        return UUID.randomUUID().toString();
    }

    public String generateAccessToken(Users user){
        return Jwts.builder()
                .setSubject(user.getInformation().getEmail())
                .claim("userId", user.showId().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 900000)) // 15 min
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
}
