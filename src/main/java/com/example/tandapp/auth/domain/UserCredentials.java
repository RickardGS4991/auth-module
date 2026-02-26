package com.example.tandapp.auth.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

public class UserCredentials {

    private final String username;
    private final String email;
    private final String password;

    public UserCredentials(String username, String email, String password){
        if(username == null || username.isBlank()) throw new IllegalArgumentException("Username inválido.");
        if(email == null || email.isBlank()) throw new IllegalArgumentException("Correo electrónico inválido.");
        if(password == null || password.isBlank()) throw new IllegalArgumentException("Contraseña inválida.");

        validateEmail(email);

        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    private void validateEmail(String email){
        if(!email.contains("@")) throw new IllegalArgumentException("Correo electronico inválido.");
    }
}
