package com.example.tandapp.auth.domain.exceptions;

public class RefreshTokenNotFound extends RuntimeException {
    public RefreshTokenNotFound() {
        super("Access not permitted.");
    }
}
