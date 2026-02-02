package com.example.tandapp.domain.models;

import java.util.UUID;

public class Member {
    private UUID memberId = null;
    private MemberInformation information;
    private final MemberAccess credentials;
    private final Boolean allowed;

    public Member(MemberInformation information, MemberAccess credentials, Boolean allowed) {
        this.information = information;
        this.credentials = credentials;
        this.allowed = allowed;
    }

    public MemberInformation getInformation() {
        return information;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public void changeName(String firstName, String lastName){
        this.information = new MemberInformation(
                firstName,
                lastName,
                information.getNumberPhone(),
                information.getCity(),
                information.getCountry(),
                information.getPostalCode(),
                information.getAddress()
        );
    }

    public void changeAddress(String city, String country, String postalCode, String address){
        this.information = new MemberInformation(
                information.getFirstName(),
                information.getLastName(),
                information.getNumberPhone(),
                city,
                country,
                postalCode,
                address
        );
    }

}
