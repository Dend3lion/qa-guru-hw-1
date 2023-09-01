package com.demoqa.tests;

import com.demoqa.fixtures.RegistrationUser;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.fixtures.RegistrationUser.*;

public class RegistrationTestWithFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        RegistrationUser user = new RegistrationUser();

        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setEmail(user.email)
                .setGender(user.gender)
                .setPhoneNumber(user.phoneNumber)
                .setBirthDate(user.birthdayDay, user.birthdayMonth, user.birthdayYear)
                .setSubjects(user.subject)
                .setHobbies(user.hobby)
                .setPicture(user.picture)
                .setAddress(user.address)
                .setState(user.state)
                .setCity(user.city)
                .submitForm();

        registrationPage
                .checkResultsTable(new String[]{
                        String.format("%s %s", user.firstName, user.lastName),
                        user.email,
                        user.gender,
                        user.phoneNumber,
                        String.format("%s %s,%s", user.birthdayDay, user.birthdayMonth, user.birthdayYear),
                        user.subject,
                        user.hobby,
                        user.picture,
                        user.address,
                        String.format("%s %s", user.state, user.city)});
    }

    @Test
    void successfulRegistrationMinimalTest() {
        RegistrationUser user = new RegistrationUser();

        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setGender(user.gender)
                .setPhoneNumber(user.phoneNumber)
                .submitForm();

        registrationPage
                .checkResultsTable(new String[]{
                        String.format("%s %s", user.firstName, user.lastName),
                        user.gender,
                        user.phoneNumber});
    }
}
