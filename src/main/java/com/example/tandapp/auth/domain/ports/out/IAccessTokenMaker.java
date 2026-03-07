package com.example.tandapp.auth.domain.ports.out;

import com.example.tandapp.auth.domain.Users;

import java.util.UUID;

public interface IAccessTokenMaker {
    String generateAccessToken(Users user);
    void validateAccessToken(String accessToken);
    String getEmailUser(String token);
    UUID getUserId(String token);
}
