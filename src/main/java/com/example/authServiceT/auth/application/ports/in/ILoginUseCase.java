package com.example.authServiceT.auth.application.ports.in;

import com.example.authServiceT.auth.application.dto.LoginUserRequest;
import com.example.authServiceT.auth.application.dto.LoginUserResponse;

public interface ILoginUseCase {
    LoginUserResponse execute(LoginUserRequest loginUserRequest);
}
