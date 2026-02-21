package com.example.tandapp.auth.domain.exceptions;

public class InformationInvalidateException extends RuntimeException {
    public InformationInvalidateException(String dataName) {
        super("El " + dataName + "no es válido.");
    }
}
