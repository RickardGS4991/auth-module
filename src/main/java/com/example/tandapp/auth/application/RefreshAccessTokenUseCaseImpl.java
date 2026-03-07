package com.example.tandapp.auth.application;

import com.example.tandapp.auth.application.ports.in.IRefreshAccessTokenUseCase;
import com.example.tandapp.auth.domain.RefreshTokens;
import com.example.tandapp.auth.application.ports.out.IAccessTokenMaker;
import com.example.tandapp.auth.domain.service.RefreshTokenValidation;
import org.springframework.stereotype.Service;

@Service
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
