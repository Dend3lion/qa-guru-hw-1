package com.demoqa.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebConfigProvider {
    private final WebConfig config;

    public WebConfigProvider(WebConfig config){
        this.config = config;
    }

    public void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowser().toString();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.browserVersion = config.getBrowserVersion();

        if (config.isRemote()) {
            Configuration.remote = config.getRemoteHost();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true

            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}