package com.example.tandapp.auth.domain;

import java.time.Instant;

import java.util.UUID;

public class RefreshTokens {
    private UUID refreshTokenId;

    private UUID userId;

    private String refreshToken;

    private Instant expiresAt;

    private boolean revoked;

    protected RefreshTokens(){}

    private RefreshTokens(UUID refreshTokenId, UUID userId, String refreshToken, Instant expiresAt, boolean revoked){
        if(userId == null) throw new IllegalArgumentException("UserID inválido. Usuario no tiene permisos.");
        if(refreshToken == null || refreshToken.isBlank()) throw new IllegalArgumentException("Token inválido.");
        if(expiresAt == null) throw new IllegalArgumentException("Fecha inválida.");

        this.refreshTokenId = refreshTokenId;
        this.userId = userId;
        this.refreshToken = refreshToken;
        this.expiresAt = expiresAt;
        this.revoked = revoked;
    }

    public static RefreshTokens create(UUID userId){
        return new RefreshTokens(UUID.randomUUID(), userId, UUID.randomUUID().toString(), Instant.now(), false);
    }

    public static RefreshTokens restore(UUID refreshTokenId, UUID userId, String refreshToken, Instant expiresAt, boolean revoked){
        return new RefreshTokens(refreshTokenId, userId, refreshToken, expiresAt, revoked);
    }

    public static boolean isExpired(Instant todayHour){
        Instant thisMoment = Instant.now();

        return thisMoment.isAfter(todayHour);
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


}

