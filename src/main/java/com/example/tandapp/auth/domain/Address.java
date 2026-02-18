package com.example.tandapp.auth.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String phoneNumber;

    protected Address(){}

    public Address(String street, String postalCode, String city, String phoneNumber){

        if(street == null || street.isBlank()) throw new IllegalArgumentException("Correo electronico inválido.");
        if(postalCode == null || postalCode.isBlank()) throw new IllegalArgumentException("Codigo postal inválido");
        if(city == null || city.isBlank()) throw new IllegalArgumentException("Ciudad inválida");
        if(phoneNumber == null || phoneNumber.isBlank()) throw new IllegalArgumentException("Numero de telefono inválido.");

        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String showStreet(){
        return street;
    }

    public String getPostalCode(){
        return postalCode;
    }

    public String getCity(){
        return city;
    }

    public String getNumberPhone(){
        return phoneNumber;
    }
}
