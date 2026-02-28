package com.example.tandapp.auth.domain.ports.out;

import com.example.tandapp.auth.domain.Users;

public interface IAccessTokenMaker {
    String generateAccessToken(Users user);
}
