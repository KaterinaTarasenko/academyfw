package org.academy.api.requests;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import org.academy.api.payloads.ProjectPayloads;
import org.json.JSONObject;

public class ProjectRequests extends Requests {
    private final ProjectPayloads projectPayloads = new ProjectPayloads();

    public Map<String, Object> createProjectRequest(String projectName) {
        Response response =
                postMethods.withoutParams(addProjectResource(), projectPayloads.projectPayload(projectName));

        JSONObject jsonObject = new JSONObject(response.asString());
        return new HashMap<String, Object>() {
            {
                put("role", jsonObject.get("name"));
            }
        };
    }
}
