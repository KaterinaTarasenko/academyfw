package org.academy.ui;

import org.academy.ui.pages.administration.ProjectsPage;
import org.academy.ui.pages.project.EditProjectPage;
import org.academy.ui.pages.project.TestSuite;
import org.academy.ui.steps.DeleteProjectSteps;
import org.academy.ui.steps.LoginSteps;
import org.academy.ui.steps.AddProjectSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProjectTest extends BaseTest {
    private LoginSteps loginSteps = new LoginSteps();
    private AddProjectSteps addProjectSteps = new AddProjectSteps();
    private DeleteProjectSteps deleteSteps = new DeleteProjectSteps();

    private EditProjectPage editProjectPage;
    private ProjectsPage projectsPage;

    private final String projectName = "Edit Project Test";

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        loginSteps.makeLogin();
        editProjectPage = addProjectSteps.createProject(projectName).clickOnProjectPage(projectName);
    }

    @Test
    public void editSuiteOfProjectTest() {
        projectsPage = editProjectPage
                .chooseTestSuite(TestSuite.MULTIPLE)
                .clickOnAcceptBtn();
    }

    @Test(priority = 1, groups = "editAnnouncement")
    public void clearAnnouncementTest() {
        projectsPage = editProjectPage
                .clearAnnouncementField()
                .clickOnAcceptBtn();
    }

    @Test(groups = "editAnnouncement")
    public void updateAnnouncementTest() {
        projectsPage = editProjectPage
                .fillAnnouncementField(getProjectAnnouncement())
                .clickOnAcceptBtn();
    }

    @AfterMethod
    public void deleteProject() {
        projectsPage.clickOnDashboardBtn();
        deleteSteps.deleteProject(projectName);
    }
}
