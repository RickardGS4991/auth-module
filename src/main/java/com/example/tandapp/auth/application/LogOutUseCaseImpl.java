package com.example.tandapp.auth.application;

import com.example.tandapp.auth.application.ports.in.ILogOutUseCase;
import com.example.tandapp.auth.domain.ports.out.IRefreshTokenRepository;

public class LogOutUseCaseImpl implements ILogOutUseCase {

    private final IRefreshTokenRepository refreshTokenRepository;

    public LogOutUseCaseImpl(IRefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Override
    public void execute(String refreshToken){
        refreshTokenRepository.deleteByRefreshToken(refreshToken);
    }
}
