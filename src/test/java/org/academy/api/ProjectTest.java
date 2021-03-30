package org.academy.api;

import java.util.Map;

import org.academy.api.requests.ProjectRequests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectTest extends BaseTest {
    private final ProjectRequests projectRequests = new ProjectRequests();

    @Test(groups = "smoke_api")
    public void createProjectCase() {
        String projectName = "project_".concat(apiHelpers.getCurrentTimestamp());
        String projectDescription = dr.getRandomStringStartsUpperCase(5, 5).toString();
        boolean toShow = true;
        int suiteMode = 1;

        String projectNameFromResponse =
                String.valueOf(projectRequests.createProjectRequest(projectName, projectDescription, toShow, suiteMode)
                                              .get("role"));
        assertThat(projectNameFromResponse).isEqualTo(projectName)
                                           .as("Project name from response should be the same as " + projectName);
    }

    @Test
    public void getProjectAttributesCase() {
        Map<String, Object> attributes = projectRequests.getProjectRequest();
        assertThat(String.valueOf(attributes.get("name"))).isEqualTo("111").as("name of project should be 111");
        assertThat(String.valueOf(attributes.get("announcement"))).isEqualTo("Test project")
                                                                  .as("announcement of project should be Test project");
        assertThat(String.valueOf(attributes.get("show_announcement"))).isEqualTo("false")
                                                                       .as("show_announcement field of project should be false");
        assertThat(String.valueOf(attributes.get("is_completed"))).isEqualTo("false")
                                                                  .as("is_completed field of project should be false");
        assertThat(String.valueOf(attributes.get("completed_on"))).isEqualTo("null")
                                                                  .as("completed_on field of project should be null");
        assertThat(String.valueOf(attributes.get("suite_mode"))).isEqualTo("1")
                                                                .as("suite_mode field of project should be 1");
        assertThat(String.valueOf(attributes.get("url")))
                .isEqualTo("https://ssacd2.testrail.io/index.php?/projects/overview/9");
    }

    @Test
    public void updateProjectCase() {
        String projectName = "updated project_".concat(apiHelpers.getCurrentTimestamp());
        String projectDescription = dr.getRandomStringStartsUpperCase(5, 5).toString();
        boolean toShow = true;
        boolean isCompleted = false;

        Map<String, Object> attributes = projectRequests.updateProjectRequest(projectName, projectDescription, toShow,
                isCompleted);
        assertThat(String.valueOf(attributes.get("name"))).isEqualTo(projectName)
                                                          .as("name of project should be " + projectName);
        assertThat(String.valueOf(attributes.get("announcement"))).isEqualTo(projectDescription)
                                                                  .as("announcement of project should be " +
                                                                          projectDescription);
        assertThat(String.valueOf(attributes.get("show_announcement"))).isEqualTo(String.valueOf(toShow))
                                                                       .as("show_announcement of project should be " +
                                                                               toShow);
        assertThat(String.valueOf(attributes.get("is_completed"))).isEqualTo(String.valueOf(isCompleted))
                                                                  .as("is_completed of project should be " +
                                                                          isCompleted);
        /*String projectNameFromResponse =
                String.valueOf(projectRequests.updateProjectRequest(projectName, projectDescription, toShow, isCompleted)
                        .get("nameOfProject").get(announcementOfProject);
        assertThat(projectNameFromResponse).isEqualTo(projectName)
                .as("Project name from response should be the same as " + projectName);*/
    }
}

