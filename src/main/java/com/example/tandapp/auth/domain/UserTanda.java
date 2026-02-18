package com.example.tandapp.auth.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class UserTanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    @Embedded
    private Address address;

    @Embedded
    private UserAccess information;

    protected UserTanda() {}

    //Before making
    public UserTanda(String firstName, String lastName, LocalDate birthDate, Address address, UserAccess information){
        if(firstName == null || firstName.isBlank()) throw new IllegalArgumentException("Nombre inválido.");
        if(lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Apellidos inválidos.");
        if(birthDate == null) throw new IllegalArgumentException("Fecha de cumpleaños invalido.");

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.information = information;
    }

    public String showName(){
        return firstName + " " + lastName;
    }

    public Long showId(){
        return userId;
    }
}
