package tests;

import dto.User;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProjectsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreateProjectTest extends BaseTest {

    private final String PROJECT_NAME = "TestProject";
    private final String PROJECT_CODE = "TestQA";

    LoginPage loginPage = new LoginPage();
    ProjectsPage projectsPage = new ProjectsPage();

    @Test
    public void checkCreateNewProject() {
        loginPage.login(User.oleg().login(), User.oleg().password());
        projectsPage.createNewProject(PROJECT_NAME,PROJECT_CODE);
        $(byText(PROJECT_NAME)).shouldBe(visible);
        projectsPage.deleteProject(PROJECT_NAME);
    }
}
