package com.example.authServiceT.auth.application.dto;

public class LoginUserResponse {
    private final String accessToken;
    private final String refreshToken;

    private LoginUserResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public static LoginUserResponse create(String accessToken, String refreshToken){
        return new LoginUserResponse(accessToken, refreshToken);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
