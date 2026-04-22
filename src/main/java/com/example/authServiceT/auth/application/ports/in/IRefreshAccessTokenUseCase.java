package com.example.authServiceT.auth.application.ports.in;

public interface IRefreshAccessTokenUseCase {
    String execute(String refreshToken);
}
