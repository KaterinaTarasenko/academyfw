package org.academy.utils.api.methods;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Set;

public class ConvertMethods {
        /**
         * this method converts response from server to hashMap (key - value)
         */

        public static HashMap<String, Object> convertResponseFromServerToHashMap(Response response) {
            JSONObject jsonArray = new JSONObject(response.asString());//there are keys and values
            Set<String> projectAttributes = jsonArray.keySet();//there I take keys from response
            HashMap<String, Object> attributesToValueHashMap = new HashMap<>();//creating hashMap
            for (String attribute : projectAttributes) { //for one iteration rewrite key from set to string 'attribute'
                attributesToValueHashMap.put(attribute, jsonArray.get(attribute));//write in hashmap key from 'attribute' than go to json object with response and search with same key value than write it in value in HashMap
            }
            return attributesToValueHashMap;
        }
    }
