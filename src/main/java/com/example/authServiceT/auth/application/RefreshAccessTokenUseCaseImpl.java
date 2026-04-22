package com.example.authServiceT.auth.application;

import com.example.authServiceT.auth.application.ports.in.IRefreshAccessTokenUseCase;
import com.example.authServiceT.auth.domain.RefreshTokens;
import com.example.authServiceT.auth.application.ports.out.IAccessTokenMaker;
import com.example.authServiceT.auth.domain.service.RefreshTokenValidation;

public class RefreshAccessTokenUseCaseImpl implements IRefreshAccessTokenUseCase {

    private final RefreshTokenValidation refreshTokenValidation;
    private final IAccessTokenMaker accessTokenMaker;

    public RefreshAccessTokenUseCaseImpl(RefreshTokenValidation refreshTokenValidation, IAccessTokenMaker accessTokenMaker) {
        this.refreshTokenValidation = refreshTokenValidation;
        this.accessTokenMaker = accessTokenMaker;
    }

    @Override
    public String execute(String refreshToken) {

        RefreshTokens newToken = refreshTokenValidation.validate(refreshToken);

        String accessToken = accessTokenMaker.generateAccessToken(newToken.getUserId(), newToken.getEmail());

        return accessToken;
    }
}
