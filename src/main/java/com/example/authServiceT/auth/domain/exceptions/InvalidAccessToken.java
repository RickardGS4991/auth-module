package com.example.authServiceT.auth.domain.exceptions;

public class InvalidAccessToken extends RuntimeException {
    public InvalidAccessToken() {
        super("Access token invalid.");
    }
}
