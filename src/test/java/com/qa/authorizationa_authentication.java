package com.qa;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class authorizationa_authentication {

    @Test
    public void basicAuth(){

        //Get Request specification of the request
        RequestSpecification requestspecs = RestAssured.given();

        //specify base url -//http://postman-echo.com/basic-auth
        requestspecs.baseUri("http://postman-echo.com");
        requestspecs.basePath("/basic-auth");

        //perform get request basic authentication
        Response response = requestspecs.auth().basic("postman" ,"password").get();

        //perform get request preemptive authentication
        Response newresponse = requestspecs.auth().preemptive().basic("postman" ,"password").get();


        //Print status line
        System.out.println("Response status :" + response.statusLine());
        System.out.println("Response status :" + newresponse.statusLine());


    }
}
