package com.qa;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class CheckForValidResponse {


    public void getSingleUser() {

        //spcify base url
        RestAssured.baseURI = "https://reqres.in/api/users/2";

        //Get Request specification of the request
        RequestSpecification requestspecs = RestAssured.given();

        //call the get method
        Response response =  requestspecs.get();

        //gets response code
        int statusCode = response.getStatusCode();

        //validate status code
        Assert.assertEquals(statusCode,200);
    }

}