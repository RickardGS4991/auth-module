package com.example.authServiceT.auth.domain.ports.out;

public interface IHasherPassword {
    String hasherPassword(String password);
    boolean matchesPassword(String rawPassword, String hashedPassword);
}
