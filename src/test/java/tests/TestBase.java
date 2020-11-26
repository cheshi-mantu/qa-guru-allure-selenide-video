package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.CustomWebDriver;
import helpers.FileReadHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.AttachmentsHelper.*;
import static helpers.Environment.selenoid_url;

public class TestBase {
    @BeforeEach
    void beforeEachTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
//         commenting next three lines will allow to run locally
        if (selenoid_url == null) {
            System.setProperty("selenoid_url", FileReadHelper.getStringFromFile("selenoid_url.secret"));
        }
//  =======================================================================================================
        Configuration.browser = CustomWebDriver.class.getName();
    }

    @AfterEach
    public void afterEach() {
        attachVideo();
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachBrowserConsoleLogs();
        closeWebDriver();
    }
}