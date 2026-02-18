package com.example.tandapp.auth.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String postalCode;
    private String city;
    private String numberPhone;

    protected Address(){}

    public Address(String street, String postalCode, String city, String numberPhone){

        if(street == null || street.isBlank()) throw new IllegalArgumentException("Correo electronico inválido.");
        if(postalCode == null || postalCode.isBlank()) throw new IllegalArgumentException("Codigo postal inválido");
        if(city == null || city.isBlank()) throw new IllegalArgumentException("Ciudad inválida");
        if(numberPhone == null || numberPhone.isBlank()) throw new IllegalArgumentException("Numero de telefono inválido.");

        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.numberPhone = numberPhone;
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
        return numberPhone;
    }
}
