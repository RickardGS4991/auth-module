package com.example.authServiceT.auth.application.dto;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class RegisterUserRequest {

    @NotBlank
    @NotNull
    private final String firstName;

    @NotNull
    @NotBlank
    private final String lastName;

    @NotNull
    @Past
    private final LocalDate birthdate;

    @NotNull
    @NotBlank
    private final String street;

    @NotNull
    @NotBlank
    private final String postalCode;

    @NotNull
    @NotBlank
    private final String city;

    @NotNull
    @NotBlank
    private final String numberPhone;

    @NotNull
    @NotBlank
    private final String username;

    @NotNull
    @NotBlank
    @Email(message = "Correo inválido.")
    private final String email;

    @NotNull
    @NotBlank
    private final String password;

    public RegisterUserRequest(String firstName, String lastName, LocalDate birthdate, String street, String postalCode, String city, String numberPhone, String username, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.numberPhone = numberPhone;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public LocalDate getBirthdate(){
        return birthdate;
    }

    public String getStreet(){
        return street;
    }

    public String getPostalCode(){
        return postalCode;
    }

    public String getCity(){
        return city;
    }

    public String getNumberPhone(){
        return numberPhone;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
