package com.example.tandapp.auth.infrastructure.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    private UUID userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Embedded
    private AddressEntity address;

    @Embedded
    private UserCredentialsEntity information;

    protected UsersEntity(){}

    public UsersEntity(UUID userId, String firstName, String lastName, LocalDate birthdate, AddressEntity address, UserCredentialsEntity information){

        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.information = information;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public UUID getUserId() {
        return userId;
    }

    public UserCredentialsEntity getInformation() {
        return information;
    }

    public AddressEntity getAddress() {
        return address;
    }
}
