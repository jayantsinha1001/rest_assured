package com.qa;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForValidResponse {

    @Test
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
        Assert.assertEquals(statusCode,200, "Status code verified");

        String StatusLine = response.getStatusLine();

        Assert.assertEquals(StatusLine , "HTTP/1.1 200 OK");
    }

    @Test
    public void GetSingleUserUsingValidatableResponse(){

        //spcify base url
        RestAssured.baseURI = "https://reqres.in/api/users/2";

        //Get Request specification of the request
        RequestSpecification requestspecs = RestAssured.given();


        //call the get method
        Response response =  requestspecs.get();

        ValidatableResponse validateRes =  response.then();

        //status code
        validateRes.statusCode(200);

        //status line
        validateRes.statusLine("HTTP/1.1 200 OK");



    }

}