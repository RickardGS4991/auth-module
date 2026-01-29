package com.example.tandapp.domain.models;

import java.time.LocalDate;

public class MemberInformation {
    private final String firstName;
    private final String surname;
    private final String lastName;
    private final LocalDate birthDate;
    private final String numberPhone;
    private final String address;
    private final String city;
    private final String state;
    private final String country;

    public MemberInformation(String firstName, String surname, String lastName, LocalDate birthDate, String numberPhone, String address, String city, String state, String country){

        if(firstName == null || firstName.isBlank()){
            throw new IllegalArgumentException("First name cannot be empty");
        }

        if(surname == null || surname.isBlank()){
            throw new IllegalArgumentException("Surname cannot be empty");
        }

        if(lastName == null || lastName.isBlank()){
            throw new IllegalArgumentException("Last name cannot be empty");
        }

        if(address == null || address.isBlank()){
            throw new IllegalArgumentException("Address cannot be empty");
        }

        if(city == null || city.isBlank()){
            throw new IllegalArgumentException("City cannot be empty");
        }

        if(state == null || state.isBlank()){
            throw new IllegalArgumentException("State cannot be empty");
        }

        if(country == null || country.isBlank()){
            throw new IllegalArgumentException("Country cannot be empty");
        }

        boolean adult = isAdult(birthDate);
        if(!adult) throw new IllegalArgumentException("Age cannot be less than 18");

        this.firstName = firstName;
        this.surname = surname;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.numberPhone = numberPhone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastName() {
        return lastName;
    }

    private Boolean isAdult(LocalDate date){
        if(date == null){
            throw new IllegalArgumentException("Age cannot be empty");
        }
        return !date.isAfter(LocalDate.now().minusYears(18));
    }
}
