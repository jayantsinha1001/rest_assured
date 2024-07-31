package com.qa;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.io.SessionOutputBuffer;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class firstgetRequest {

    @Test
    void testcase01(){
        Response res = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(res.asString());
        System.out.println("status code :  " + res.getStatusCode());
        System.out.println("Response body : " + res.getBody());
        System.out.println("Response time : " + res.getTime());
    }

    @Test
    public void test_get02(){
        RestAssured.baseURI ="https://reqres.in/api/users";
        RestAssured.given().queryParam("page" , "2").when().get().then().statusCode(200).log().all();
    }

    @Test
    public void test_post03(){

        JSONObject jsonObject =  new JSONObject();
        jsonObject.put("Name" ,"Ram");
        jsonObject.put("Job","QA");

        RestAssured.baseURI= "https://reqres.in/api/users";
        RestAssured.given().header("content-type" , "application/json").
                contentType(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().post().
                then().statusCode(201).log().all();
    }

    @Test
    public void validateHeader(){
        JSONObject jsonObject =  new JSONObject();
        jsonObject.put("Name" ,"SITA");
        jsonObject.put("Job","BA");

        RestAssured.baseURI= "https://reqres.in/api/users/12";
        RestAssured.given().header("content-type" , "application/json").
                contentType(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().post().
                then().statusCode(201).log().all();
    }
}
