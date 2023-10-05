package com.demoqa.config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:${env}.properties",
})
public interface WebConfig extends Config{
    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    Browser getBrowser();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("isRemote")
    @DefaultValue("true")
    Boolean isRemote();

    @Key("remoteHost")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getRemoteHost();
}
