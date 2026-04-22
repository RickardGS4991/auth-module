package com.example.authServiceT.auth.domain.exceptions;

public class RefreshTokenExpired extends RuntimeException {
    public RefreshTokenExpired() {
        super("Refresh token expired");
    }
}
