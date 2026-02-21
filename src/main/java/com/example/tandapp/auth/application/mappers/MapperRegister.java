package com.example.tandapp.auth.application.mappers;

import com.example.tandapp.auth.application.dto.RegisterUserRequest;
import com.example.tandapp.auth.domain.Address;
import com.example.tandapp.auth.domain.UserAccess;
import com.example.tandapp.auth.domain.Users;
import org.springframework.stereotype.Component;

@Component
public class MapperRegister {
    public Users mapperRegisterUser(RegisterUserRequest info, String hashedPassword) {
        return new Users(info.getFirstName(), info.getLastName(), info.getBirthdate(), new Address(info.getStreet(), info.getPostalCode(), info.getCity(), info.getNumberPhone()), new UserAccess(info.getUsername(), info.getEmail(), hashedPassword));
    }
}
