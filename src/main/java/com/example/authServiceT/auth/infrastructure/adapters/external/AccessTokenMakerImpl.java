package com.example.authServiceT.auth.infrastructure.adapters.external;

import com.example.authServiceT.auth.domain.exceptions.InvalidAccessToken;
import com.example.authServiceT.auth.application.ports.out.IAccessTokenMaker;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Component
public class AccessTokenMakerImpl implements IAccessTokenMaker {

    @Value("${jwt.secret}")
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
    public String generateAccessToken(UUID userId, String email) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public void validateAccessToken(String accessToken){
        try{
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(accessToken);
        } catch(JwtException | IllegalArgumentException e){
            throw new InvalidAccessToken();
        }
    }

    @Override
    public String getEmailUser(String token){
        return getAllClaims(token).getSubject();
    }

    @Override
    public UUID getUserId(String accessToken){
        return getAllClaims(accessToken).get("userId",UUID.class);
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(this.secret.getBytes(StandardCharsets.UTF_8));
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
