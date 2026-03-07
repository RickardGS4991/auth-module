package com.example.tandapp.auth.domain.exceptions;

public class InvalidAccessToken extends RuntimeException {
    public InvalidAccessToken() {
        super("Access token invalid.");
    }
}
