package com.example.authServiceT.auth.application;

import com.example.authServiceT.auth.application.dto.RegisterUserRequest;
import com.example.authServiceT.auth.application.ports.in.IRegisterUseCase;
import com.example.authServiceT.auth.domain.ports.out.IHasherPassword;
import com.example.authServiceT.auth.domain.Address;
import com.example.authServiceT.auth.domain.UserCredentials;
import com.example.authServiceT.auth.domain.Users;
import com.example.authServiceT.auth.domain.exceptions.InformationAlreadyEnteredException;
import com.example.authServiceT.auth.domain.ports.out.IUserRepository;
import com.example.authServiceT.auth.domain.service.UserValidation;

public class RegisterUseCaseImpl implements IRegisterUseCase {
    private final UserValidation validator;
    private final IUserRepository userAuthRepository;
    private final IHasherPassword hasherPassword;

    public RegisterUseCaseImpl(UserValidation validator, IUserRepository userAuthRepository, IHasherPassword hasherPassword) {
        this.validator = validator;
        this.userAuthRepository = userAuthRepository;
        this.hasherPassword = hasherPassword;
    }

    @Override
    public void execute(RegisterUserRequest information){
        if(validator.verifyEmail(information.getEmail())){
            throw new InformationAlreadyEnteredException("email");
        }

        String hashedPassword = hasherPassword.hasherPassword(information.getPassword());

        Users newMember = Users.create(information.getFirstName(), information.getLastName(), information.getBirthdate(), new Address(information.getStreet(), information.getPostalCode(), information.getCity(), information.getNumberPhone()), new UserCredentials(information.getUsername(), information.getEmail(), hashedPassword));

        userAuthRepository.save(newMember);

    }
}
