package com.example.authServiceT.auth.application;

import com.example.authServiceT.auth.application.dto.LoginUserRequest;
import com.example.authServiceT.auth.application.dto.LoginUserResponse;
import com.example.authServiceT.auth.application.ports.in.ILoginUseCase;
import com.example.authServiceT.auth.domain.RefreshTokens;
import com.example.authServiceT.auth.domain.Users;
import com.example.authServiceT.auth.application.ports.out.IAccessTokenMaker;
import com.example.authServiceT.auth.domain.ports.out.IRefreshTokenRepository;
import com.example.authServiceT.auth.domain.service.UserValidation;

public class LoginUseCaseImpl implements ILoginUseCase {
    private final UserValidation userValidation;
    private final IAccessTokenMaker tokensMaker;
    private final IRefreshTokenRepository repository;

    public LoginUseCaseImpl(UserValidation userValidation, IAccessTokenMaker tokensMaker, IRefreshTokenRepository repository) {
        this.userValidation = userValidation;
        this.tokensMaker = tokensMaker;
        this.repository = repository;
    }

    @Override
    public LoginUserResponse execute(LoginUserRequest loginUserRequest) {
        Users member = userValidation.getUserInformation(loginUserRequest.getEmail(), loginUserRequest.getPassword());

        String accessToken = tokensMaker.generateAccessToken(member.showId(), member.getInformation().getEmail());
        RefreshTokens refreshToken = RefreshTokens.create(member.showId(), member.getInformation().getEmail());

        repository.save(refreshToken);

        LoginUserResponse newTokens = LoginUserResponse.create(accessToken, refreshToken.showRToken());

        return newTokens;

    }
}
