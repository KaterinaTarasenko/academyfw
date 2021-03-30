package org.academy.api.requests;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SuiteRequests extends Requests {
    public static int projectId = 2;

    public Map<String,Object> getAllSuitesRequest() {
        Response response = getMethods.withoutParams(allSuitesResource());

        JSONArray jsonArray = new JSONArray(response.asString());
        return new HashMap<String, Object>() {
            {
                put("name", ((JSONObject) jsonArray.get(0)).get("name"));
            }
        };
    }
}
