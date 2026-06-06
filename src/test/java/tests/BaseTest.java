package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {


    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://app.qase.io/";
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito"); // - без инкогнито тоже всплывашка shadow-root появляется
        options.addArguments("--disable-notifications");
        Configuration.browserCapabilities = options;
    }
}