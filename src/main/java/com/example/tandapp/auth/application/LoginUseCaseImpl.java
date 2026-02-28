package com.example.tandapp.auth.application;

import com.example.tandapp.auth.application.dto.LoginUserRequest;
import com.example.tandapp.auth.application.dto.LoginUserResponse;
import com.example.tandapp.auth.application.ports.in.ILoginUseCase;
import com.example.tandapp.auth.domain.Users;
import com.example.tandapp.auth.domain.ports.out.ITokensMaker;
import com.example.tandapp.auth.domain.service.UserValidation;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCaseImpl implements ILoginUseCase {
    private final UserValidation userValidation;
    private final ITokensMaker tokensMaker;

    public LoginUseCaseImpl(UserValidation userValidation, ITokensMaker tokensMaker) {
        this.userValidation = userValidation;
        this.tokensMaker = tokensMaker;
    }

    @Override
    public LoginUserResponse execute(LoginUserRequest loginUserRequest) {
        Users member = userValidation.getUserInformation(loginUserRequest.getEmail(), loginUserRequest.getPassword());

        String accessToken = tokensMaker.generateAccessToken(member);
        String refreshToken = tokensMaker.generateRefreshToken();

    }


}
