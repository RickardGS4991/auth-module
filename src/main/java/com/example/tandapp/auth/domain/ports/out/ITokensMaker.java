package com.example.tandapp.auth.domain.ports.out;

import com.example.tandapp.auth.domain.Users;

public interface ITokensMaker {
    String generateRefreshToken();
    String generateAccessToken(Users user);
}
