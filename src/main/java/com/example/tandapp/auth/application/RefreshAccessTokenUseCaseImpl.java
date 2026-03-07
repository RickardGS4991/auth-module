package com.example.tandapp.auth.application;

import com.example.tandapp.auth.application.ports.in.IRefreshAccessTokenUseCase;
import com.example.tandapp.auth.domain.exceptions.RefreshTokenExpired;
import com.example.tandapp.auth.domain.ports.out.IAccessTokenMaker;
import com.example.tandapp.auth.domain.service.RefreshTokenValidation;

public class RefreshAccessTokenUseCaseImpl implements IRefreshAccessTokenUseCase {

    private final RefreshTokenValidation refreshTokenValidation;
    private final IAccessTokenMaker accessTokenMaker;

    public RefreshAccessTokenUseCaseImpl(RefreshTokenValidation refreshTokenValidation, IAccessTokenMaker accessTokenMaker) {
        this.refreshTokenValidation = refreshTokenValidation;
        this.accessTokenMaker = accessTokenMaker;
    }

    @Override
    public String execute(String refreshToken) {
        if(!refreshTokenValidation.validate(refreshToken)){
            throw new RefreshTokenExpired();
        }

        return null;
    }
}
