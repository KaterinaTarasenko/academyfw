package org.academy.api.steps;

import org.academy.api.models.project.ProjectModel;
import org.academy.api.requests.ProjectRequests;
import org.academy.ui.steps.Steps;

import java.util.List;

public class ProjectSteps extends Steps {
    private final ProjectRequests projectRequests = new ProjectRequests();

    public int getProjectIdByProjectName(String projectName) {
        int projectId = -1;

        List<ProjectModel> projectsList = projectRequests.getProjectsRequest();
        for (ProjectModel project : projectsList) {
            if (project.getName().equals(projectName))
                projectId = project.getId();
        }

        return projectId;
    }
}
