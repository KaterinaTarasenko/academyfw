package org.academy.api.requests;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
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


    public Map<String, Object> updateProjectRequest(String projectName, String announcement, boolean showAnnouncement,
                                                    boolean isCompleted) {
        Response response =
                postMethods.withoutParams(updateProjectResource(), projectPayloads.updateProjectPayload(projectName, announcement, showAnnouncement, isCompleted));
        return ConvertMethods.convertResponseFromServerToHashMap(response);
        /*JSONObject jsonObject = new JSONObject(response.asString());
        return new HashMap<String, Object>() {
            {
                put("nameOfProject", jsonObject.get("name"));
                put("announcementOfProject", jsonObject.get("announcement"));
                put("showAnnouncementOfProject", jsonObject.get("show_announcement"));
                put("isCompletedOfProject", jsonObject.get("is_completed"));
            }
        }*/
    }
}