package com.qa;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validate_JSON_Response_Body {

    @Test
    public  void userlistresponsebody(){

        //spcify base url
        RestAssured.baseURI = "https://reqres.in/api/users?page=2";

        //Get Request specification of the request
        RequestSpecification requestspecs = RestAssured.given();


        //call the get method
        Response response = requestspecs.get();

        //read response body
        ResponseBody responsebody = response.getBody();

        String responsestring = responsebody.asString();

        //print responseBody
        System.out.println(responsestring);

        //validation to check response body. check for firstname as janet or not
        Assert.assertEquals(responsestring.contains("janet") , true,"check for presence of janet");

        //get JSON path view of response body
        JsonPath jsonpath = responsebody.jsonPath();
        String firstname = jsonpath.get("data[4].first_name");
        System.out.println("firstname: " + firstname);

    }
}
