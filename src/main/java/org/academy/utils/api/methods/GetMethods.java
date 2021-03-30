package org.academy.utils.api.methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;
import static org.academy.api.requests.Resources.prefixResource;

@Slf4j
public class GetMethods extends Method {

    public Response withoutParams(String resource) {
        RestAssured.baseURI = getAccountUrl();
        Response response = given()
                .auth().preemptive().basic(getEmail(), getPassword())
                .contentType(ContentType.JSON)
                .queryParam(resource)
                .when()
                .get(prefixResource())
                .then()
                .extract()
                .response();
        log.info("Response returned - {}", response.asString());
        return response;
    }
}
