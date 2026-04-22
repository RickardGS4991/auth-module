package com.example.authServiceT.auth.domain.exceptions;

public class RefreshTokenNotFound extends RuntimeException {
    public RefreshTokenNotFound() {
        super("Access not permitted.");
    }
}
