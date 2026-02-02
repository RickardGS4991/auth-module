package com.example.tandapp.domain.models;

public class MemberInformation {
    private final String firstName;
    private final String lastName;
    private final String numberPhone;
    private final String city;
    private final String country;
    private final String postalCode;
    private final String address;

    public MemberInformation(String firstName, String lastName, String numberPhone, String city, String country, String postalCode, String address) {
        if(firstName == null || firstName.isBlank()) throw new IllegalArgumentException("First name cannot be null or blank");
        if(lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be null or blank");
        if(numberPhone == null || numberPhone.isBlank()) throw new IllegalArgumentException("Phone number cannot be null or blank");
        if(city == null || city.isBlank()) throw new IllegalArgumentException("City cannot be null or blank");
        if(country == null || country.isBlank()) throw new IllegalArgumentException("Country cannot be null or blank");
        if(postalCode == null || postalCode.isBlank()) throw new IllegalArgumentException("Postal code cannot be null or blank");
        if(address == null || address.isBlank()) throw new IllegalArgumentException("Address cannot be null or blank");

        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.address = address;
    }

    public String getCompleteName(){
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getAddress(){
        return address;
    }

    public String getNumberPhone(){
        return numberPhone;
    }

    public String getCity(){
        return city;
    }

    public String getCountry(){
        return country;
    }

    public String getPostalCode(){
        return postalCode;
    }
}
