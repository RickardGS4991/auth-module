package com.example.tandapp.domain.models;

public class MemberAccess {
    private final String email;
    private final String password;
    private final String username;

    public MemberAccess(String email, String password, String username){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
}
