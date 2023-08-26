package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationTestWithPageObject extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName("Shrek")
                .setLastName("Zeleniy")
                .setEmail("shker@boloto.ru")
                .setGender("Male")
                .setPhoneNumber("8800553535")
                .setBirthDate("01", "October", "1900")
                .setSubjects("Arts")
                .setHobbies("Sports")
                .setPicture("photo.jpg")
                .setAddress("Boloto, Derevo i budka, 1")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();

        registrationPage
                .checkResultsTable(new String[]{
                        "Shrek Zeleniy",
                        "shker@boloto.ru",
                        "Male",
                        "8800553535",
                        "01 October,1900",
                        "Arts",
                        "Sports",
                        "photo.jpg",
                        "Boloto, Derevo i budka, 1",
                        "NCR Delhi"});
    }

    @Test
    void successfulRegistrationMinimalTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName("Shrek")
                .setLastName("Zeleniy")
                .setGender("Male")
                .setPhoneNumber("8800553535")
                .submitForm();

        registrationPage
                .checkResultsTable(new String[]{
                        "Shrek Zeleniy",
                        "Male",
                        "8800553535"});
    }
}