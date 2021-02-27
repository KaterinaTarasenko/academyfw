package org.academy.api.requests;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.restassured.response.Response;
import org.academy.api.payloads.ProjectPayloads;
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
        return processResponse(response);
    }

    private HashMap<String, Object> processResponse(Response response) {
        JSONObject jsonArray = new JSONObject(response.asString());//there are keys and values
        Set<String> projectAttributes = jsonArray.keySet();//there I take keys
        HashMap<String, Object> attributesToValueHashMap = new HashMap<>();
        for (String attribute : projectAttributes) {
            attributesToValueHashMap.put(attribute, jsonArray.get(attribute));
        }
        return attributesToValueHashMap;
    }

    public Map<String, Object> updateProjectRequest(String projectName) {
        Response response =
                postMethods.withoutParams(updateProjectResource(), projectPayloads.projectAllFieldsPayload(projectName));
        return processResponse(response);
    }
}