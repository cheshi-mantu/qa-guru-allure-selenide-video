package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
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
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
//        Configuration.browser = "opera";
//        Configuration.startMaximized = true;
    }
    @BeforeEach
    void beforeEachTest(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("EnableVNC", true);
        capabilities.setCapability("EnableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = selenide_remote;
    }
    @AfterEach
    public void closeBrowser(){
        closeWebDriver();
    }
}
