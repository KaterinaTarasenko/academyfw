package org.academy.api.requests;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.academy.api.payloads.MilestonePayloads;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MilestoneRequests extends Requests {
    private final MilestonePayloads milestonePayloads = new MilestonePayloads();

    public Map<String, Object> getMilestoneRequest(String milestoneId){
        Response response = getMethods.withoutParams(milestoneResource(milestoneId));

        JSONObject jsonObject = new JSONObject(response.asString());

        return new HashMap<String, Object>(){
            {
                put("name", jsonObject.get("name"));
            }
        };
    }

    public Map<String, Object> updateMilestoneRequest(String milestoneId){
        Response response =
                postMethods.withoutParams(updateMilestoneResource(milestoneId), milestonePayloads.milestonePayload());

        JSONObject jsonObject = new JSONObject(response.asString());
        return new HashMap<String, Object>(){
            {
                put("name", jsonObject.get("name"));
            }
        };
    }
}
