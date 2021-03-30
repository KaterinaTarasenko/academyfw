package org.academy.api.requests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.response.Response;
import org.academy.api.models.project.ProjectModel;
import org.academy.api.payloads.ProjectPayloads;

import org.academy.utils.api.methods.ConvertMethods;
import org.json.JSONObject;

public class ProjectRequests extends Requests {
    private final ProjectPayloads projectPayloads = new ProjectPayloads();

    public Map<String, Object> createProjectRequest(String projectName, String announcement, boolean showAnnouncement,
                                                    int... suiteMode) {
        Response response =
                postMethods.withoutParams(addProjectResource(),
                        projectPayloads.createProjectPayload(projectName, announcement, showAnnouncement, suiteMode));

        JSONObject jsonObject = new JSONObject(response.asString());
        return new HashMap<String, Object>() {
            {
                put("role", jsonObject.get("name"));
            }
        };
    }

    public Map<String, Object> getProjectRequest() {
        Response response = getMethods.withoutParams(getProjectResource());
        return ConvertMethods.convertResponseFromServerToHashMap(response);
    }

    public List<ProjectModel> getProjectsRequest() {
        Response response = getMethods.withoutParams(getProjectsResource());
        return Arrays.asList(response.getBody().as(ProjectModel[].class));
    }

    public Map<String, Object> updateProjectRequest(String projectName, String announcement, boolean showAnnouncement,
                                                    boolean isCompleted) {
        Response response =
                postMethods.withoutParams(updateProjectResource(9), projectPayloads.updateProjectPayload(projectName, announcement, showAnnouncement, isCompleted));
        return ConvertMethods.convertResponseFromServerToHashMap(response);
    }

    public Map<String, Object> updateProjectRequest(int projectId, String projectName, String announcement, int suiteMode) {
        Response response = postMethods.withoutParams(
                updateProjectResource(projectId),
                projectPayloads.updateProjectPayload(projectName, announcement, suiteMode));
        return ConvertMethods.convertResponseFromServerToHashMap(response);
    }
}