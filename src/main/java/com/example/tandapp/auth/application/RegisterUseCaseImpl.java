package com.example.tandapp.auth.application;

import com.example.tandapp.auth.application.base.IRegisterUseCase;
import com.example.tandapp.auth.application.dto.RegisterUserRequest;
import com.example.tandapp.auth.application.mappers.MapperRegister;
import com.example.tandapp.auth.application.security.IHasherPassword;
import com.example.tandapp.auth.domain.Users;
import com.example.tandapp.auth.domain.exceptions.InformationAlreadyEnteredException;
import com.example.tandapp.auth.domain.service.UserValidation;
import org.springframework.stereotype.Service;

@Service
public class RegisterUseCaseImpl implements IRegisterUseCase {
    private final MapperRegister mapper;
    private final IHasherPassword hasher;
    private final UserValidation validator;

    public RegisterUseCaseImpl(MapperRegister mapper, IHasherPassword hasher, UserValidation validator){
        this.mapper = mapper;
        this.hasher = hasher;
        this.validator = validator;
    }

    @Override
    public void execute(RegisterUserRequest information){
        if(validator.verifyEmail(information.getEmail())){
            throw new InformationAlreadyEnteredException("email");
        }
        String hashedPassword = hasher.hasherPassword(information.getPassword());

        Users newInformation = mapper.mapperRegisterUser(information, hashedPassword);

    }
}
