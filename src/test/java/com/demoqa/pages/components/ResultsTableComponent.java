package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {
    SelenideElement resultsTable = $(".table-responsive");

    public void checkResult(String value) {
        resultsTable.shouldHave(text(value));
    }
}
