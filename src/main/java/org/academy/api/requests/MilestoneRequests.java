package org.academy.api.requests;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.academy.api.payloads.MilestonePayloads;
import org.academy.utils.api.methods.ConvertMethods;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;
@Slf4j
public class MilestoneRequests extends Requests {
    private final MilestonePayloads milestonePayloads = new MilestonePayloads();

    public Map<String, Object> addMilestoneRequest(String name, String... description){

        Response response =
                postMethods.withoutParams(addMilestoneToProjectResource(),
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

    public Map<String, Object> getAllMilestonesRequest() {
        Response response = getMethods.withoutParams(getMilestonesResource());

        log.info("response code is " + response.getStatusCode());
        return ConvertMethods.convertResponseFromServerToHashMap(response);
    }
}
