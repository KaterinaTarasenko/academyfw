package org.academy.utils.api.methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.academy.api.requests.Resources.prefixResource;

@Slf4j
public class PostMethods extends Method {

    public Response withoutParams(String resource, String payload) {
        RestAssured.baseURI = getAccountUrl();
        Response response = given()
                .auth().preemptive().basic(getEmail(), getPassword())
                .contentType(ContentType.JSON)
                .queryParam(resource)
                .body(payload)
                .when()
                .post(prefixResource())
                .then()
                .extract()
                .response();
        log.info("Response returned - {}", response.asString());
        return response;
    }

    public Response withoutParams(String resource, JSONObject payload) {
        RestAssured.baseURI = getAccountUrl();
        Response response = given()
                .auth().preemptive().basic(getEmail(), getPassword())
                .contentType(ContentType.JSON)
                .queryParam(resource)
                .body(payload)
                .when()
                .post(prefixResource())
                .then()
                .statusCode(200)
                .extract()
                .response();
        log.info("Response returned - {}", response.asString());
        return response;
    }
}
