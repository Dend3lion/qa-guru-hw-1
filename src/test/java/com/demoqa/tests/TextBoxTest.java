package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .seUserName("Shrek Zeleniy")
                .setUserEmail("shker@boloto.ru")
                .setCurrentAddress("Boloto, Derevo i budka, 1")
                .setPermanentAddress("Boloto, Derevo i budka, 100500")
                .submitForm();

        textBoxPage
                .checkOutput(new String[]{
                        "Shrek Zeleniy",
                        "shker@boloto.ru",
                        "Boloto, Derevo i budka, 1",
                        "Boloto, Derevo i budka, 100500"});
    }
}
