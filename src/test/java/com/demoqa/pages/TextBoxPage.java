package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    SelenideElement
            userNameField = $("#userName"),
            userEmailField = $("#userEmail"),
            currentAddressField = $("#currentAddress"),
            permanentAddressField = $("#permanentAddress"),
            submitButton = $("#submit"),
            nameOutput = $("#output #name"),
            emailOutput = $("#output #email"),
            currentAddressOutput = $("#output #currentAddress"),
            permanentAddressOutput = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage seUserName(String value) {
        userNameField.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailField.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressField.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressField.setValue(value);

        return this;
    }

    public TextBoxPage submitForm() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkOutput(String[] values) {
        nameOutput.shouldHave(text(values[0]));
        emailOutput.shouldHave(text(values[1]));
        currentAddressOutput.shouldHave(text(values[2]));
        permanentAddressOutput.shouldHave(text(values[3]));

        return this;
    }

}
