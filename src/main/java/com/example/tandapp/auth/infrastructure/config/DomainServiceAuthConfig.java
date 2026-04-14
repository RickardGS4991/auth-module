package com.example.tandapp.auth.infrastructure.config;

import com.example.tandapp.auth.application.ports.out.IEmailCheckRepository;
import com.example.tandapp.auth.domain.ports.out.IHasherPassword;
import com.example.tandapp.auth.domain.ports.out.IRefreshTokenRepository;
import com.example.tandapp.auth.domain.ports.out.IUserRepository;
import com.example.tandapp.auth.domain.service.RefreshTokenValidation;
import com.example.tandapp.auth.domain.service.UserValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainServiceAuthConfig {
    @Bean
    public UserValidation userValidation(IEmailCheckRepository emailCheckRepository, IUserRepository getUserInformation, IHasherPassword hasherPassword) {
        return new UserValidation(emailCheckRepository, getUserInformation, hasherPassword);

    }

    @Bean
    public RefreshTokenValidation refreshTokenValidation(IRefreshTokenRepository userRepository) {
        return new RefreshTokenValidation(userRepository);
    }
}
