package com.example.tandapp.auth.application;

import com.example.tandapp.auth.application.dto.LoginUserRequest;
import com.example.tandapp.auth.application.security.IHasherPassword;
import com.example.tandapp.auth.domain.repository.ILoginUseCase;

public class LoginUseCaseImpl implements ILoginUseCase {
    private IHasherPassword hasherPassword;

    public LoginUseCaseImpl(IHasherPassword hasherPassword){
        this.hasherPassword = hasherPassword;
    }

    @Override
    public void execute(LoginUserRequest info) {

    }
}
