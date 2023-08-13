package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillAllFields() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        String firstName = "Shrek";
        String lastName = "Zeleniy";
        String userEmail = "shker@boloto.ru";
        String gender = "Male";
        String userNumber = "8800553535";
        String dateOfBirthInput = "01 October,1900";
        String subjectsInput = "Arts";
        String hobbies = "Sports";
        String photoName = "photo.jpg";
        String currentAddress = "Boloto, Derevo i budka, 1";
        String state = "NCR";
        String city = "Delhi";

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOptionByValue("1900");
        $x("(//*[@class='react-datepicker__week']//*[text()='1'])[1]").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(photoName);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        $x("//td[text()='Student Name']/following-sibling::td").shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']/following-sibling::td").shouldHave(text(userEmail));
        $x("//td[text()='Gender']/following-sibling::td").shouldHave(text(gender));
        $x("//td[text()='Mobile']/following-sibling::td").shouldHave(text(userNumber));
        $x("//td[text()='Date of Birth']/following-sibling::td").shouldHave(text(dateOfBirthInput));
        $x("//td[text()='Subjects']/following-sibling::td").shouldHave(text(subjectsInput));
        $x("//td[text()='Hobbies']/following-sibling::td").shouldHave(text(hobbies));
        $x("//td[text()='Picture']/following-sibling::td").shouldHave(text(photoName));
        $x("//td[text()='Address']/following-sibling::td").shouldHave(text(currentAddress));
        $x("//td[text()='State and City']/following-sibling::td").shouldHave(text(state + " " + city));
    }
}
