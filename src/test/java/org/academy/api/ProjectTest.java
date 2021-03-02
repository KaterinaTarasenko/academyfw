package org.academy.api;

import org.academy.api.requests.ProjectRequests;
import org.academy.api.requests.UserRequests;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Set;

import static org.academy.api.payloads.ProjectPayloads.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ProjectTest extends BaseTest {
    private final ProjectRequests projectRequests = new ProjectRequests();

    @Test
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
        assertThat(String.valueOf(attributes.get("announcement"))).isEqualTo("Test project").as("announcement of project should be Test project");
        assertThat(String.valueOf(attributes.get("show_announcement"))).isEqualTo("false").as("show_announcement field of project should be false");
        assertThat(String.valueOf(attributes.get("is_completed"))).isEqualTo("false").as("is_completed field of project should be false");
        assertThat(String.valueOf(attributes.get("completed_on"))).isEqualTo("null").as("completed_on field of project should be null");
        assertThat(String.valueOf(attributes.get("suite_mode"))).isEqualTo("1").as("suite_mode field of project should be 1");
        assertThat(String.valueOf(attributes.get("url"))).isEqualTo("https://ssacd2.testrail.io/index.php?/projects/overview/1");
    }

    @Test
    public void updateProjectAttributesCase() {
        String updated_project = "Updated project";
        Map<String, Object> attributes = projectRequests.updateProjectRequest(updated_project);
        assertThat(String.valueOf(attributes.get("name"))).isEqualTo(updated_project).as("name of project should be "+updated_project);
        assertThat(String.valueOf(attributes.get("announcement"))).isEqualTo(ANNOUNCEMENT).as("announcement of project should be Test project");
        assertThat(String.valueOf(attributes.get("show_announcement"))).isEqualTo(String.valueOf(SHOW_ANNOUNCEMENT)).as("show_announcement field of project should be false");
        assertThat(String.valueOf(attributes.get("is_completed"))).isEqualTo(String.valueOf(IS_COMPLETED)).as("is_completed field of project should be false");
    }
}

