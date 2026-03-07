package com.example.tandapp.auth.domain.service;

import com.example.tandapp.auth.domain.RefreshTokens;
import com.example.tandapp.auth.domain.exceptions.RefreshTokenExpired;
import com.example.tandapp.auth.domain.exceptions.RefreshTokenNotFound;
import com.example.tandapp.auth.domain.ports.out.IRefreshTokenRepository;
import org.springframework.stereotype.Service;

@Service //Después se deberá crear un contenedor, para evitar tener una libreria externa en la capa de dominio
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
