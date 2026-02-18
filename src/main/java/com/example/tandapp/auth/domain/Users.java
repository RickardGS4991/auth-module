package com.example.tandapp.auth.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Users {
    @Id
    private UUID userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Embedded
    private Address address;

    @Embedded
    private UserAccess information;

    protected Users() {}

    public Users(String firstName, String lastName, LocalDate birthdate, Address address, UserAccess information){
        if(firstName == null || firstName.isBlank()) throw new IllegalArgumentException("Nombre inválido.");
        if(lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Apellidos inválidos.");
        if(birthdate == null) throw new IllegalArgumentException("Fecha de cumpleaños invalido.");

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.information = information;
    }

    public String showName(){
        return firstName + " " + lastName;
    }

    public UUID showId(){
        return userId;
    }
}
