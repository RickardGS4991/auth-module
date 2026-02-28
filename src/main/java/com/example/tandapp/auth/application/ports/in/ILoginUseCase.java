package com.example.tandapp.auth.application.ports.in;

import com.example.tandapp.auth.application.dto.LoginUserRequest;
import com.example.tandapp.auth.application.dto.LoginUserResponse;

public interface ILoginUseCase {
    LoginUserResponse execute(LoginUserRequest loginUserRequest);
}
