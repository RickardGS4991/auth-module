package com.example.authServiceT.auth.application;

import com.example.authServiceT.auth.application.ports.in.ILogOutUseCase;
import com.example.authServiceT.auth.domain.ports.out.IRefreshTokenRepository;

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
