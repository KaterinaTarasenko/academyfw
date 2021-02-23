package org.academy.api.requests;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;

@Slf4j
public class UserRequests extends Requests {
    public Map<String, Object> getAllUsersRequest() {
        Response response = getMethods.withoutParams(allUsersResource());

        JSONArray jsonArray = new JSONArray(response.asString());
        return new HashMap<String, Object>() {
            {
                put("role", ((JSONObject) jsonArray.get(0)).get("role"));
            }
        };
    }
}
