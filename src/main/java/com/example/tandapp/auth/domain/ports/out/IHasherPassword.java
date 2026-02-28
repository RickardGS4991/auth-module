package com.example.tandapp.auth.domain.ports.out;

public interface IHasherPassword {
    String hasherPassword(String password);
    boolean matchesPassword(String rawPassword, String hashedPassword);
}
