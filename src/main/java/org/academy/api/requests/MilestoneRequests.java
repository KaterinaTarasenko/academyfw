package org.academy.api.requests;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.academy.api.payloads.MilestonePayloads;
import org.academy.utils.api.methods.ConvertMethods;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
@Slf4j
public class MilestoneRequests extends Requests {
    private final MilestonePayloads milestonePayloads = new MilestonePayloads();

    public Map<String, Object> getMilestoneRequest(String milestoneId) {
        Response response = getMethods.withoutParams(getMilestoneResource(milestoneId));
        return ConvertMethods.convertResponseFromServerToHashMap(response);
    }

    public Map<String, Object> addMilestoneRequest(String projectId, String name, String... description){

        Response response =
                postMethods.withoutParams(addMilestoneToProjectResource(projectId),
                        milestonePayloads.addMilestoneToProjectPayload(name, description));

        log.info("response code is " + response.getStatusCode());
        return ConvertMethods.convertResponseFromServerToHashMap(response);
    }


    public Map<String, Object> updateMilestoneWithCompleteResource(String milestoneId, String name, String description, boolean... isCompleted) {

        Response response =
                postMethods.withoutParams(updateMilestoneResource(milestoneId),
                        milestonePayloads.updateMilestoneWithCompleteField(name, description, isCompleted));

        log.info("response code is " + response.getStatusCode());
        return ConvertMethods.convertResponseFromServerToHashMap(response);
    }

    public Map<String, Object> getAllMilestonesRequest(String projectId) {
        Response response = getMethods.withoutParams(getAllMilestonesResource(projectId));

        log.info("response code is " + response.getStatusCode());
        JSONObject jsonObject = new JSONObject(response.asString()
                .substring(1, response.asString().length() - 1));
        HashMap<String, Object> allMilestones = new HashMap<>();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            allMilestones.put(key, jsonObject.get(key));
        }
        return allMilestones;
        //return ConvertMethods.convertResponseFromServerToHashMap(response);
    }
}
