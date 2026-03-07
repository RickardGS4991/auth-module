package com.example.tandapp.auth.domain.exceptions;

public class RefreshTokenExpired extends RuntimeException {
    public RefreshTokenExpired() {
        super("Refresh token expired");
    }
}
