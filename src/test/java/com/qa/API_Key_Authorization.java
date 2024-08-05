package com.qa;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Key_Authorization {

    @Test
    public void getwheatherData(){


        //https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.baseUri("https://api.openweathermap.org");
        requestSpec.basePath("/data/2.5/weather");
        requestSpec.queryParam("q" , "Dhanbad").queryParam("appid","a77ba38316028c4a13ca2fc39283179d");
        Response response= requestSpec.get();

        //validate status code
        Assert.assertEquals((response.getStatusCode()), 200);

        //print status line and response body
        System.out.println("Response status line " + response.statusLine());
        System.out.println("Response body " + response.body().asString());

    }
}
