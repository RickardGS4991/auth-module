package com.example.tandapp.auth.domain;

import java.time.Instant;

import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class RefreshTokens {
    private final UUID refreshTokenId;

    private final UUID userId;

    private final String email;

    private final String refreshToken;

    private final Instant expiresAt;

    private boolean revoked;

    private RefreshTokens(UUID refreshTokenId, UUID userId, String email, String refreshToken, Instant expiresAt, boolean revoked){
        if(userId == null) throw new IllegalArgumentException("UserID inválido. Usuario no tiene permisos.");
        if(email == null) throw new IllegalArgumentException("Email inválido.");
        if(refreshToken == null || refreshToken.isBlank()) throw new IllegalArgumentException("Token inválido.");
        if(expiresAt == null) throw new IllegalArgumentException("Fecha inválida.");

        this.refreshTokenId = refreshTokenId;
        this.userId = userId;
        this.email = email;
        this.refreshToken = refreshToken;
        this.expiresAt = expiresAt;
        this.revoked = revoked;
    }

    public static RefreshTokens create(UUID userId, String email){
        return new RefreshTokens(UUID.randomUUID(), userId, email, UUID.randomUUID().toString(), Instant.now(), false);
    }

    public static RefreshTokens restore(UUID refreshTokenId, UUID userId, String email, String refreshToken, Instant expiresAt, boolean revoked){
        return new RefreshTokens(refreshTokenId, userId, email, refreshToken, expiresAt, revoked);
    }

    public static boolean isExpired(Instant birthHour){
        long lifeCycle = 8;

        Instant expirationTime = birthHour.plus(lifeCycle, ChronoUnit.HOURS);

        return Instant.now().isAfter(expirationTime);
    }

    public boolean isRevoked(){
        return revoked;
    }

    public String showRToken(){
        return refreshToken;
    }

    public UUID showRefreshTokenId(){
        return refreshTokenId;
    }

    public UUID getUserId(){
        return userId;
    }

    public Instant getExpiresAt(){
        return expiresAt;
    }

    public String getEmail(){
        return email;
    }


}

