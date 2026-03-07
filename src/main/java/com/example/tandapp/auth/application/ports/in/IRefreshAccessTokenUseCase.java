package com.example.tandapp.auth.application.ports.in;

public interface IRefreshAccessTokenUseCase {
    String execute(String refreshToken);
}
