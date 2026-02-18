package com.example.tandapp.auth.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserAccess {

    private String username;
    private String email;
    private String passwordHash;

    protected UserAccess(){}

    public UserAccess(String username, String email, String passwordHash){
        if(username == null || username.isBlank()) throw new IllegalArgumentException("Username inválido.");
        if(email == null || email.isBlank()) throw new IllegalArgumentException("Correo electrónico inválido.");
        if(passwordHash == null || passwordHash.isBlank()) throw new IllegalArgumentException("Contraseña inválida.");

        validateEmail(email);

        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPasswordHash(){
        return passwordHash;
    }

    private void validateEmail(String email){
        if(!email.contains("@")) throw new IllegalArgumentException("Correo electronico inválido.");
    }
}
