package org.academy.api.requests;

import io.restassured.response.Response;
import org.academy.api.payloads.CasePayloads;
import org.academy.utils.api.methods.ConvertMethods;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class CasesRequests extends Requests {
    private final CasePayloads casePayloads = new CasePayloads();
    private final String suiteId = "1";
    private final String projectId = "1";
    private final String caseId = "1";

    public Map<String, Object> createCaseRequest(String caseName) {
        Response response =
                postMethods.withoutParams(addCaseResource().concat(suiteId),
                        casePayloads.createCasePayload(caseName));

        JSONObject jsonObject = new JSONObject(response.asString());
        return new HashMap<String, Object>() {
            {
                put("title", jsonObject.get("title"));
            }
        };
    }

    public Map<String,Object> getAllCasesRequest() {
        Response response = getMethods.withoutParams(allCasesResource()
                        .concat(projectId));
        JSONObject jsonObject = new JSONObject(response.asString()
                .substring(1, response.asString().length() - 1));
        HashMap<String, Object> allCases = new HashMap<>();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            allCases.put(key, jsonObject.get(key));
        }
        return allCases;
    }

    public Map<String,Object> getCaseRequest() {
        Response response = getMethods.withoutParams(getCaseResourse()
        .concat(caseId));
        return ConvertMethods.convertResponseFromServerToHashMap(response);
    }
}
