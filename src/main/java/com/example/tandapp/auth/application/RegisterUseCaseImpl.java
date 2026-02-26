package com.example.tandapp.auth.application;

import com.example.tandapp.auth.application.base.IRegisterUseCase;
import com.example.tandapp.auth.application.dto.RegisterUserRequest;
import com.example.tandapp.auth.application.security.IHasherPassword;
import com.example.tandapp.auth.domain.Address;
import com.example.tandapp.auth.domain.UserCredentials;
import com.example.tandapp.auth.domain.Users;
import com.example.tandapp.auth.domain.exceptions.InformationAlreadyEnteredException;
import com.example.tandapp.auth.domain.repository.IUserAuth;
import com.example.tandapp.auth.domain.service.UserValidation;
import org.springframework.stereotype.Service;

@Service
public class RegisterUseCaseImpl implements IRegisterUseCase {
    private final UserValidation validator;
    private final IUserAuth userAuthRepository;
    private final IHasherPassword hasherPassword;

    public RegisterUseCaseImpl(UserValidation validator, IUserAuth userAuthRepository, IHasherPassword hasherPassword) {
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
