package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {

    private final SelenideElement createNewProjectBtn = $(byText("Create new project"));
    private final SelenideElement projectNameInput = $("#project-name");
    private final SelenideElement projectCodeInput = $("#project-code");
    private final SelenideElement submitProjectBtn = $(byText("Create project"));
    private final SelenideElement projectsNavigationLink = $("a[href='/projects']");
    private final SelenideElement removeMenuOption = $("[data-testid='remove']");
    private final SelenideElement confirmDeleteBtn = $(byText("Delete project"));

    public void openProjectPage() {
        open("projects");
    }

    public void createNewProject(String projectName,String projectCode) {
        createNewProjectBtn.shouldBe(visible).click();
        projectNameInput.setValue(projectName);
        projectCodeInput.setValue(projectCode);
        submitProjectBtn.click();
        projectsNavigationLink.click();
    }

    public void deleteProject(String projectName) {
        $(byText(projectName))
                .shouldBe(visible)
                .closest("tr")
                .$("button[aria-label='Open action menu']")
                .click();

        removeMenuOption.shouldBe(visible).click();
        confirmDeleteBtn.shouldBe(visible).click();
    }
}