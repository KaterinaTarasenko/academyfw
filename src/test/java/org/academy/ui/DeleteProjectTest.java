package org.academy.ui;

import org.academy.ui.pages.administration.ProjectsPage;
import org.academy.ui.steps.LoginSteps;
import org.academy.ui.steps.AddProjectSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteProjectTest extends BaseTest {
    private LoginSteps loginSteps = new LoginSteps();
    private AddProjectSteps addProjectSteps = new AddProjectSteps();

    private ProjectsPage projectsPage;

    private String projectName = "Remove Project";

    @BeforeMethod(alwaysRun = true)
    public void precondition() throws InterruptedException {
        loginSteps.makeLogin();
        projectsPage = addProjectSteps.createProject(projectName);
    }

    @Test
    public void removeProjectTest() {
        projectsPage
                .clickRemoveBtn(projectName)
                .clickOnCheckbox()
                .clickOnOkBtn();
    }
}
