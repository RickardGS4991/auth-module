package com.example.authServiceT.auth.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Users {

    private final UUID userId;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthdate;
    private final Address address;
    private final UserCredentials information;

    private Users(UUID userId, String firstName, String lastName, LocalDate birthdate, Address address, UserCredentials information){
        if(firstName == null || firstName.isBlank()) throw new IllegalArgumentException("Nombre inválido.");
        if(lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Apellidos inválidos.");
        if(birthdate == null) throw new IllegalArgumentException("Fecha de cumpleaños invalido.");

        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.information = information;
    }

    public static Users create(String firstName, String lastName, LocalDate birthdate, Address address, UserCredentials information){
        return new Users(UUID.randomUUID(), firstName, lastName, birthdate, address, information);
    }

    public static Users restore(UUID userId, String firstName, String lastName, LocalDate birthdate, Address address, UserCredentials information){
        return new Users(userId, firstName, lastName, birthdate, address, information);
    }

    public String showName(){
        return firstName + " " + lastName;
    }

    public UUID showId(){
        return userId;
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

    public Address getAddress() {
        return address;
    }

    public UserCredentials getInformation() {
        return information;
    }
}
