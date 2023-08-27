package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.fixtures.RegistrationUser.*;

public class RegistrationTestWithFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(birthdayDay, birthdayMonth, birthdayYear)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();

        registrationPage
                .checkResultsTable(new String[]{
                        String.format("%s %s", firstName, lastName),
                        email,
                        gender,
                        phoneNumber,
                        String.format("%s %s,%s", birthdayDay, birthdayMonth, birthdayYear),
                        subject,
                        hobby,
                        picture,
                        address,
                        String.format("%s %s", state, city)});
    }

    @Test
    void successfulRegistrationMinimalTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .submitForm();

        registrationPage
                .checkResultsTable(new String[]{
                        String.format("%s %s", firstName, lastName),
                        gender,
                        phoneNumber});
    }
}
