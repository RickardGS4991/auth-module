package com.example.authServiceT.auth.entities;

import com.example.authServiceT.auth.domain.Address;
import com.example.authServiceT.auth.domain.UserCredentials;
import com.example.authServiceT.auth.domain.Users;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    // UserCredentials Entity Test
    @Test
    public void shouldThrowErrorWhenEmailIsInvalid() {
        Address address = new Address("Mock street", "Mock city", "Mock state", "Mock zipcode");
        LocalDate cumpleanios = LocalDate.of(1995, 5, 15);

        assertThatThrownBy(() -> {
            UserCredentials information = new UserCredentials("DemoMock", "holaMundo.com", "01234");

            Users.create("MockName", "MockLastName", cumpleanios, address, information);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Correo electronico inválido.");
    }

    @Test
    public void shouldThrowErrorWhenUsernameIsInvalid(){
        Address address = new Address("MockStreet", "MockCity", "MockState", "MockZipcode");
        LocalDate mockCumpleanios = LocalDate.of(1995, 5, 15);

        assertThatThrownBy(() -> {
            UserCredentials information = new UserCredentials("", "holaMundo.com", "01234");
            Users.create("MockName", "MockLastName", mockCumpleanios, address, information);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Username inválido.");
    }

    @Test
    public void ErrorWhenPasswordIsInvalid(){
        Address address = new Address("MockStreet", "MockCity", "MockState", "MockZipcode");
        LocalDate mockCumpleanios = LocalDate.of(1995, 5, 15);

        assertThatThrownBy(() -> {
           UserCredentials informationMock = new UserCredentials("MockUserName", "holaMundo@hotmail.com", "");
           Users.create("MockName", "MockLastName", mockCumpleanios, address, informationMock);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Contraseña inválida.");
    }

    //Address Entity Test

    @Test
    public void ErrorWhenStreetIsInvalid(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Address("", "MockCity", "MockState", "MockZipcode");
        });
    }

    @Test
    public void ErrorWhenPostalCodeIsInvalid(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Address("MockStreet", "", "MockState", "MockZipcode");
        });
    }

    @Test
    public void ErrorWhenCityIsInvalid(){
        UserCredentials mockInformation = new UserCredentials("MockUserName", "holaMundo@mock.com", "01234");
        LocalDate mockCumpleanios = LocalDate.of(1995, 5, 15);

        assertThatThrownBy(() -> {
            Address mockAddress = new Address("MockStreet", "MockCity", "", "MockZipcode");
            Users.create("MockName", "MockLastName", mockCumpleanios, mockAddress, mockInformation);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Ciudad inválida");

    }

    @Test
    public void errorWhenPhoneIsInvalid(){
        UserCredentials mockInformation = new UserCredentials("mockUserName", "mockEmail@hotmail.com", "mockPassword");
        LocalDate mockCumpleanios = LocalDate.of(1995,5,15);
        assertThatThrownBy(() -> {
            Address mockAddress = new Address("MockStreet", "MockCity", "mockCity", "");
            Users.create("MockName", "MockLastName", mockCumpleanios, mockAddress, mockInformation);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Numero de telefono inválido.");
    }

    //Users Entity Tests
    @Test
    public void errorWhenFirstNameIsInvalid(){
        Address mockAddress = new Address("MockStreet", "MockCity", "MockState", "MockNumberPhone");
        UserCredentials mockInformation = new UserCredentials("MockUserName", "mockEmail@.com", "mockPassword");
        LocalDate mockCumpleanios = LocalDate.of(1995,5,15);

        assertThatThrownBy(() -> Users.create("", "mockLastName", mockCumpleanios, mockAddress, mockInformation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Nombre inválido.");
    }

    @Test
    public void errorWhenLastNameIsInvalid(){
        Address mockAddress = new Address("MockStreet", "MockCity", "MockState", "MockNumberPhone");
        UserCredentials mockInformation = new UserCredentials("MockUserName", "mockEmail@.com", "mockPassword");
        LocalDate mockCumpleanios = LocalDate.of(1995,5,15);

        assertThrows(IllegalArgumentException.class, () -> {
            Users.create("MockName", "", mockCumpleanios, mockAddress, mockInformation);
        });
    }
}
