package com.example.tandapp.auth.application.security;

public interface IHasherPassword {
    String hasherPassword(String password);
    boolean matchesPassword(String rawPassword, String hashedPassword);
}
