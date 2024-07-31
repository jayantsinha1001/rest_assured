package com.qa;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.io.SessionOutputBuffer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validate_Response_header {

    @Test
    public void get_response_header() {
        //spcify base url
        RestAssured.baseURI = "https://reqres.in/api/users/2";

        //Get Request specification of the request
        RequestSpecification requestspecs = RestAssured.given();

        //call the get method
        Response response = requestspecs.get();

        //gets response Header
        String connection = response.getHeader("connection");

        System.out.println("value of connection is :   " + connection);


        //Fetchig all headers and Print them
        Headers headersList = response.getHeaders();

        for (Header header : headersList){
            System.out.println(header.getName() + " : " +   header.getValue());
        }

        //validate header content-type , expected value: application/json; charset=utf-8
        String contentType = response.getHeader("Content-Type");

        Assert.assertEquals(contentType , "application/json; charset=utf-8" ,"content Type Mismatch");
    }
}