package com.qa;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeserializationJSON {


   //  https://reqres.in/api/users?page=2
    /*
    * {
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}*/
    @Test
    public void desrializationDemo(){

        //Get Request specification of the request
        RequestSpecification requestspecs = RestAssured.given();

        //specify base url
        requestspecs.baseUri("https://reqres.in");
        requestspecs.basePath("/api/users");

        JSONObject jsonobject = new JSONObject();
        jsonobject.put("name" ,"jk");
        jsonobject.put("job" ,"QA");

        //perform POST request
       Response response =  requestspecs.
                contentType(ContentType.JSON).
                body(jsonobject.toJSONString()).
                post();

        //converting response body in class object

        ResponseBody responseBody = response.getBody();

        //deserialization of responseBody i.e json response body to class
        //class(T) is generic form of any class of type T which is also reffered a class template
        
        Deserialization_Data jsonPostResponseRequest = responseBody.as(Deserialization_Data.class);

        Assert.assertEquals(jsonPostResponseRequest.name , "jk" ,"check for Name");
        Assert.assertEquals(jsonPostResponseRequest.job ,"QA" ,"CHECK ");


    }
}
