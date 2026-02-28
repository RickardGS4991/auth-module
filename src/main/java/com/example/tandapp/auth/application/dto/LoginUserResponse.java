package com.example.tandapp.auth.application.dto;

public class LoginUserResponse {
    private final String accessToken;
    private final String refreshToken;

    public LoginUserResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
