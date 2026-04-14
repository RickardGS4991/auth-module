package com.example.tandapp.auth.infrastructure.config;

import com.example.tandapp.auth.application.LogOutUseCaseImpl;
import com.example.tandapp.auth.application.LoginUseCaseImpl;
import com.example.tandapp.auth.application.RefreshAccessTokenUseCaseImpl;
import com.example.tandapp.auth.application.RegisterUseCaseImpl;
import com.example.tandapp.auth.application.ports.out.IAccessTokenMaker;
import com.example.tandapp.auth.domain.ports.out.IHasherPassword;
import com.example.tandapp.auth.domain.ports.out.IRefreshTokenRepository;
import com.example.tandapp.auth.domain.ports.out.IUserRepository;
import com.example.tandapp.auth.domain.service.RefreshTokenValidation;
import com.example.tandapp.auth.domain.service.UserValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {
    @Bean
    public LoginUseCaseImpl loginUseCaseImpl(UserValidation userValidation, IAccessTokenMaker tokensMaker, IRefreshTokenRepository repository) {
        return new LoginUseCaseImpl(userValidation, tokensMaker, repository);
    }

    @Bean
    public LogOutUseCaseImpl logOutUseCaseImpl(IRefreshTokenRepository repository) {
        return new LogOutUseCaseImpl(repository);
    }

    @Bean
    public RefreshAccessTokenUseCaseImpl refreshAccessTokenUseCaseImpl(RefreshTokenValidation refreshTokenValidation, IAccessTokenMaker accessTokenMaker) {
        return new RefreshAccessTokenUseCaseImpl(refreshTokenValidation, accessTokenMaker);
    }

    @Bean
    public RegisterUseCaseImpl registerUseCaseImpl(UserValidation validator, IUserRepository userAuthRepository, IHasherPassword hasherPassword) {
        return new RegisterUseCaseImpl(validator,  userAuthRepository, hasherPassword);
    }
}
