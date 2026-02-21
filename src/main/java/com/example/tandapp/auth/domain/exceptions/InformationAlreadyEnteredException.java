package com.example.tandapp.auth.domain.exceptions;

public class InformationAlreadyEnteredException extends RuntimeException{
    public InformationAlreadyEnteredException(String nameData){
        super("El " + nameData + " ya fue registrado.");
    }
}
