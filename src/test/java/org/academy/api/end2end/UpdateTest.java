package org.academy.api.end2end;

import lombok.extern.slf4j.Slf4j;
import org.academy.api.requests.ProjectRequests;
import org.academy.api.steps.ProjectSteps;
import org.academy.ui.BaseTest;
import org.academy.ui.pages.administration.ProjectsPage;
import org.academy.ui.pages.project.EditProjectPage;
import org.academy.ui.steps.AddProjectSteps;
import org.academy.ui.steps.DeleteProjectSteps;
import org.academy.ui.steps.LoginSteps;
import org.academy.utils.helpers.ApiHelpers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class UpdateTest extends BaseTest {
    private LoginSteps loginSteps = new LoginSteps();
    private AddProjectSteps addProjectSteps = new AddProjectSteps();
    private DeleteProjectSteps deleteSteps = new DeleteProjectSteps();
    private ProjectSteps projectSteps = new ProjectSteps();

    private final ProjectRequests projectRequests = new ProjectRequests();

    private ProjectsPage projectsPage;
    private String projectName;

    private ApiHelpers apiHelpers = new ApiHelpers();

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        loginSteps.makeLogin();

        projectName = "project_".concat(apiHelpers.getCurrentTimestamp());
    }

    @Test
    public void updateEndToEndTest() {
        projectsPage = addProjectSteps.createProject(projectName);
        int projectId = projectSteps.getProjectIdByProjectName(projectName);

        assertThat(projectId).isGreaterThan(-1);

        Map<String, Object> attributes = projectRequests.updateProjectRequest(
                projectId, projectName,"Some new announcement", 2);

        EditProjectPage projectPage = projectsPage.clickOnProjectPage(projectName);

        assertThat(String.valueOf(attributes.get("announcement"))).isEqualTo(projectPage.getAnnouncementText());
        assertThat(attributes.get("suite_mode")).isEqualTo(projectPage.getSuiteMode());

        projectsPage = projectPage.clickOnCancelBtn();
    }

    @AfterMethod(alwaysRun = true)
    public void afterCondition() {
        projectsPage.clickOnDashboardBtn();
        deleteSteps.deleteProject(projectName);
    }
}
