package com.example.authServiceT.auth.domain.exceptions;

public class IncorrectAccessException extends RuntimeException {
    public IncorrectAccessException() {
        super("Correo o contraseña incorrectos.");
    }
}
