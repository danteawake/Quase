package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement emailInput = $(byName("email"));
    private final SelenideElement passwordInput = $(byName("password"));
    private final SelenideElement signInButton = $(byText("Sign in"));
    private final SelenideElement projectsNavigationLink = $("a[href='/projects']");

    public void openLoginPage() {
        open("login");
    }

    public void login(String login, String password) {
        openLoginPage();
        emailInput.shouldBe(visible).setValue(login);
        passwordInput.setValue(password);
        signInButton.click();
        projectsNavigationLink.shouldBe(visible).click();
    }
}