package com.example.tandapp.auth.application;

import com.example.tandapp.auth.application.base.IRegisterUseCase;
import com.example.tandapp.auth.application.dto.RegisterUserRequest;
import com.example.tandapp.auth.application.mappers.MapperRegister;
import com.example.tandapp.auth.application.security.IHasherPassword;
import com.example.tandapp.auth.domain.Users;
import org.springframework.stereotype.Service;

@Service
public class RegisterUseCaseImpl implements IRegisterUseCase {
    private final MapperRegister mapper;
    private final IHasherPassword hasher;

    public RegisterUseCaseImpl(MapperRegister mapper, IHasherPassword hasher){
        this.mapper = mapper;
        this.hasher = hasher;
    }

    @Override
    public void execute(RegisterUserRequest information){
        String hashedPassword = hasher.hasherPassword(information.getPassword());

        Users newInformation = mapper.mapperRegisterUser(information, hashedPassword);

    }
}
