package com.example.authServiceT.auth.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "refresh_tokens")
public class RefreshTokensEntity {
    @Id
    private UUID refreshTokenId;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String refreshToken;

    @Column(nullable = false)
    private Instant expiresAt;

    @Column(nullable = false)
    private boolean revoked;

    protected RefreshTokensEntity(){}

    public RefreshTokensEntity(UUID refreshTokenId, UUID userId, String email, String refreshToken, Instant expiresAt, boolean revoked){
        this.refreshTokenId = refreshTokenId;
        this.userId = userId;
        this.email = email;
        this.refreshToken = refreshToken;
        this.expiresAt = expiresAt;
        this.revoked = revoked;
    }

    public UUID getRefreshTokenId(){
        return refreshTokenId;
    }

    public UUID getUserId(){
        return userId;
    }

    public String getEmail(){
        return email;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public Instant getExpiresAt(){
        return  expiresAt;
    }

    public boolean getRevokedState(){
        return revoked;
    }
}
