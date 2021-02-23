package org.academy.api;

import org.academy.api.requests.ProjectRequests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectTest extends BaseTest {
    private final ProjectRequests projectRequests = new ProjectRequests();

    @Test
    public void createProjectCase() {
        String projectName = "project_".concat(apiHelpers.getCurrentTimestamp());
        String projectNameFromResponse =
                String.valueOf(projectRequests.createProjectRequest(projectName).get("role"));
        assertThat(projectNameFromResponse).isEqualTo(projectName)
                                           .as("Project name from response should be the same as " + projectName);
    }
}
