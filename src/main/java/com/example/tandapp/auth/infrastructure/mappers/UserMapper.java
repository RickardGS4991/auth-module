package com.example.tandapp.auth.infrastructure.mappers;

import com.example.tandapp.auth.domain.Address;
import com.example.tandapp.auth.domain.UserCredentials;
import com.example.tandapp.auth.domain.Users;
import com.example.tandapp.auth.infrastructure.entities.AddressEntity;
import com.example.tandapp.auth.infrastructure.entities.UserCredentialsEntity;
import com.example.tandapp.auth.infrastructure.entities.UsersEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public Users toDomain(UsersEntity member) {
        Address address = new Address(member.getAddress().getStreet(), member.getAddress().getPostalCode(), member.getAddress().getCity(), member.getAddress().getNumberPhone());
        UserCredentials information = new UserCredentials(member.getInformation().getUsername(), member.getInformation().getEmail(), member.getInformation().getPassword());
        return Users.restore(member.getUserId(), member.getFirstName(), member.getLastName(), member.getBirthdate(), address, information);
    }

    public UsersEntity toPersistance(Users member) {
        AddressEntity iAddress = new AddressEntity(member.getAddress().showStreet(), member.getAddress().getPostalCode(), member.getAddress().getCity(), member.getAddress().getNumberPhone());
        UserCredentialsEntity iUserCredentials = new UserCredentialsEntity(member.getInformation().getUsername(), member.getInformation().getEmail(), member.getInformation().getPassword());

        return new UsersEntity(member.showId(), member.getFirstName(), member.getLastName(), member.getBirthdate(), iAddress, iUserCredentials);
    }
}
