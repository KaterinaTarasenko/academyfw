package org.academy.api.end2end;

import org.academy.api.requests.MilestoneRequests;
import org.academy.api.steps.ProjectSteps;
import org.academy.ui.BaseTest;
import org.academy.ui.pages.MainPage;
import org.academy.ui.pages.MilestonePage;
import org.academy.ui.pages.RunsPage;
import org.academy.ui.pages.administration.ProjectsPage;
import org.academy.ui.steps.AddProjectSteps;
import org.academy.ui.steps.LoginSteps;
import org.academy.utils.helpers.ApiHelpers;
import org.academy.utils.helpers.DataRandomizer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MilestoneEndToEnd extends BaseTest {
    private LoginSteps loginSteps = new LoginSteps();
    private AddProjectSteps addProjectSteps = new AddProjectSteps();
    private ProjectSteps projectSteps = new ProjectSteps();

    private String projectName;
    private ProjectsPage projectsPage;

    private final MilestoneRequests milestoneRequests = new MilestoneRequests();

    private ApiHelpers apiHelpers = new ApiHelpers();
    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        loginSteps.makeLogin();
        projectName = "project_".concat(apiHelpers.getCurrentTimestampUnix());
    }

    @Test
    public void addMilestoneCase() {
        String milestoneName = "Release_".concat(apiHelpers.getCurrentTimestamp());
        String description = "Some new description";

        projectsPage = addProjectSteps.createProject(projectName);
        int projectId = projectSteps.getProjectIdByProjectName(projectName);

        assertThat(projectId).isGreaterThan(-1);

        Map<String, Object> attributes = milestoneRequests.addMilestoneRequest(String.valueOf(projectId), milestoneName);

        String milestoneId = String.valueOf(attributes.get("id"));

        MilestonePage milestonePage = projectsPage.goToDashboard().clickOnMilestonePage(projectName)
                .editMilestonePage(milestoneName)
                .clickEditBtn()
                .fillDescriptionField(description)
                .clickOnAcceptBtn();

        Map<String, Object> newAttributes = milestoneRequests.getMilestoneRequest(milestoneId);

        assertThat(newAttributes.get("description")).isEqualTo(description);

    }
}
