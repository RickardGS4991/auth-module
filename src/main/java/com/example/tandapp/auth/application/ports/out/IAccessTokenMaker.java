package com.example.tandapp.auth.application.ports.out;

import java.util.UUID;

public interface IAccessTokenMaker {
    String generateAccessToken(UUID userId, String email);
    void validateAccessToken(String accessToken);
    String getEmailUser(String token);
    UUID getUserId(String token);
}
