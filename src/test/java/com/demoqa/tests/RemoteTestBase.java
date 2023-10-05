package com.demoqa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.config.WebConfig;
import com.demoqa.config.WebConfigProvider;
import com.demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class RemoteTestBase {
    private static WebConfig config;

    @BeforeAll
    static void beforeAll() {
        config = ConfigFactory.create(WebConfig.class, System.getProperties());
        WebConfigProvider webConfig = new WebConfigProvider(config);
        webConfig.setUp();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (config.isRemote()) {
            Attach.addVideo();
        }

        closeWebDriver();
    }

}
