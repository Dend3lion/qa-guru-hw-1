package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    SelenideElement
            firstNameField = $("#firstName"),
            lastNameField = $("#lastName"),
            emailField = $("#userEmail"),
            genderField = $("#genterWrapper"),
            phoneNumberField = $("#userNumber"),
            birthDateField = $("#dateOfBirthInput"),
            subjectsField = $("#subjectsInput"),
            hobbiesField = $("#hobbiesWrapper"),
            pictureField = $("#uploadPicture"),
            addressField = $("#currentAddress"),
            stateField = $("#state"),
            stateDropdown = $("#stateCity-wrapper #state"),
            cityField = $("#city"),
            cityDropdown = $("#stateCity-wrapper #city"),
            submitButton = $("#submit");

    CalendarComponent calendar = new CalendarComponent();
    ResultsTableComponent table = new ResultsTableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameField.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameField.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailField.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderField.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberField.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateField.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsField.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesField.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value) {
        pictureField.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressField.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateField.click();
        stateDropdown.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityField.click();
        cityDropdown.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResultsTable(String[] values) {
        for (String value : values) {
            table.checkResult(value);
        }
        return this;
    }

}
