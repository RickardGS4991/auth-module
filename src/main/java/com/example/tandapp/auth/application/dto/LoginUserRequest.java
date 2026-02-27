package com.example.tandapp.auth.application.dto;

public class LoginUserRequest {
    public String email;
    public String password;

    public LoginUserRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
