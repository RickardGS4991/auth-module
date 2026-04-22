package com.example.authServiceT.auth.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AddressEntity {

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String phoneNumber;

    protected AddressEntity(){}

    public AddressEntity(String street, String postalCode, String city, String phoneNumber){

        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
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
        return phoneNumber;
    }
}
