package com.example.tandapp.auth.domain.service;

import com.example.tandapp.auth.domain.RefreshTokens;
import com.example.tandapp.auth.domain.exceptions.RefreshTokenNotFound;
import com.example.tandapp.auth.domain.ports.out.IRefreshTokenRepository;

public class RefreshTokenValidation {
    private final IRefreshTokenRepository repository;

    public RefreshTokenValidation(IRefreshTokenRepository repository) {
        this.repository = repository;
    }

    public boolean validate(String token) {
        RefreshTokens tokenFromDb = repository.validate(token).orElseThrow(RefreshTokenNotFound::new);

        return RefreshTokens.isExpired(tokenFromDb.getExpiresAt());
    }
}
