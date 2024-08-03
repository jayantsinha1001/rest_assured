package com.qa;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class authorization_usingBearerToken {

    @Test
    public void bearerToken(){
        //Get Request specification of the request
        RequestSpecification requestspecs = RestAssured.given();

        //specify base url -//http://postman-echo.com/basic-auth
        requestspecs.baseUri("https://gorest.co.in");
        requestspecs.basePath("/public/v2/users");

        JSONObject payload = new JSONObject();
        payload.put("name", "jk");
        payload.put("name", "vk");

        String AuthToken = "Bearer fd87d55640f7fe1e13b3e9d516f7e8063afe389552be9133c25b8077f5a82e1c";

        requestspecs.header("Authorization" , AuthToken).contentType(ContentType.JSON).body(payload);


    }
}
