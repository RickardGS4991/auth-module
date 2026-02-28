package com.example.tandapp.auth.application;

import com.example.tandapp.auth.application.dto.LoginUserRequest;
import com.example.tandapp.auth.application.dto.LoginUserResponse;
import com.example.tandapp.auth.application.ports.in.ILoginUseCase;
import com.example.tandapp.auth.domain.RefreshTokens;
import com.example.tandapp.auth.domain.Users;
import com.example.tandapp.auth.domain.ports.out.IAccessTokenMaker;
import com.example.tandapp.auth.domain.ports.out.IRefreshTokenRepository;
import com.example.tandapp.auth.domain.service.UserValidation;
import org.springframework.stereotype.Service;

@Service
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

        String accessToken = tokensMaker.generateAccessToken(member);
        RefreshTokens refreshToken = RefreshTokens.create(member.showId());

        repository.save(refreshToken);

        LoginUserResponse newTokens = LoginUserResponse.create(accessToken, refreshToken.showRToken());

        return newTokens;

    }


}
