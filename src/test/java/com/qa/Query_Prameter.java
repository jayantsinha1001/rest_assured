package com.qa;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Query_Prameter {

    @Test
    public void filterData(){

        //Get Request specification of the request
        RequestSpecification requestspecs = RestAssured.given();

        //specify base url
        requestspecs.baseUri("https://reqres.in");
        requestspecs.basePath("/api/users");
        requestspecs.queryParam("page",2);

        //perform the get Request
        Response response = requestspecs.get();

        //read response body
        String responseBodyString = response.getBody().asString();

        //print response body
        System.out.println("Respone Body"  + responseBodyString );

        //get json path view of response body
        JsonPath jsonPathView = response.jsonPath();

        //get first name
        //x.data.first_name
        String firstName = jsonPathView.get("data.first_name").toString();
        System.out.println("First name :" + firstName);






    }
}
