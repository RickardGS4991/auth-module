package com.example.authServiceT.auth.domain.service;

import com.example.authServiceT.auth.domain.RefreshTokens;
import com.example.authServiceT.auth.domain.exceptions.RefreshTokenExpired;
import com.example.authServiceT.auth.domain.exceptions.RefreshTokenNotFound;
import com.example.authServiceT.auth.domain.ports.out.IRefreshTokenRepository;

public class RefreshTokenValidation {
    private final IRefreshTokenRepository repository;

    public RefreshTokenValidation(IRefreshTokenRepository repository) {
        this.repository = repository;
    }

    public RefreshTokens validate(String token) {
        RefreshTokens tokenFromDb = repository.findByToken(token).orElseThrow(RefreshTokenNotFound::new);

        if(!RefreshTokens.isExpired(tokenFromDb.getExpiresAt())){
            throw new RefreshTokenExpired();
        }

        return tokenFromDb;
    }
}
