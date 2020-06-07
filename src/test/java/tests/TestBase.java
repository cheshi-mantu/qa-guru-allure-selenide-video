package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.FileReadHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.Environment.selenide_remote;

public class TestBase {
    @BeforeAll
    public static void setUp() {
        System.out.println("Yeee-haaaaa. Sorry for dumb message, this is just a stub for now");
//        Configuration.browser = "opera";
//        Configuration.startMaximized = true;
    }

    @BeforeEach
    void beforeEachTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("EnableVNC", true);
        capabilities.setCapability("EnableVideo", true);
        Configuration.browserCapabilities = capabilities;

        if (selenide_remote == "null") {
            Configuration.remote = FileReadHelper.getStringFromFile("selenide_remote.secret");
        } else {
            Configuration.remote = selenide_remote;
        }
    }

    @AfterEach
    public void closeBrowser() {
        closeWebDriver();
    }
}