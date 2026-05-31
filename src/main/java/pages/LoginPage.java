package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement emailInput = $(byName("email"));
    private final SelenideElement passwordInput = $(byName("password"));
    private final SelenideElement signInButton = $(byText("Sign in"));
    private final SelenideElement projectsNavigationLink = $("a[href='/projects']");
    private final SelenideElement shadowOpenCookieWindow = $(shadowCss("#accept",
            "#usercentrics-cmp-ui"));

    public void openLoginPage() {
        open("login");
    }

    public void login(String login, String password) {
        openLoginPage();
        if (shadowOpenCookieWindow.exists()) {
            shadowOpenCookieWindow.click();
        }
        emailInput.shouldBe(visible).setValue(login);
        passwordInput.setValue(password);
        signInButton.click();
        projectsNavigationLink.shouldBe(visible).click();
    }
}