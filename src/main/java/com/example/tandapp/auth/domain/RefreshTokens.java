package com.example.tandapp.auth.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.Instant;

import java.util.UUID;

@Entity
public class RefreshTokens {
    @Id
    private UUID refreshTokenId;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String refreshToken;

    @Column(nullable = false)
    private Instant expiresAt;

    @Column(nullable = false)
    private boolean revoked;

    protected RefreshTokens(){}

    public RefreshTokens(UUID userId, String refreshToken, Instant expiresAt, boolean revoked){
        if(userId == null) throw new IllegalArgumentException("UserID inválido. Usuario no tiene permisos.");
        if(refreshToken == null || refreshToken.isBlank()) throw new IllegalArgumentException("Token inválido.");
        if(expiresAt == null) throw new IllegalArgumentException("Fecha inválida.");

        this.userId = userId;
        this.refreshToken = refreshToken;
        this.expiresAt = expiresAt;
        this.revoked = revoked;
    }

    public boolean isExpired(Instant todayHour){
        Instant thisMoment = Instant.now();

        return thisMoment.isAfter(todayHour);
    }

    public boolean isRevoked(){
        return revoked;
    }

    public String showRToken(){
        return refreshToken;
    }

    public UUID showIdRt(){
        return refreshTokenId;
    }


}

