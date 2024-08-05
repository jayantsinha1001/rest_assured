package com.qa;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class fileUploadDemo {

   @Test
    public void FileUpload(){

       File Test_Upload_file = new File("C:\\Users\\HP\\Downloads\\dwsample3-json.json");

       //Create Request Specification
       RequestSpecification requestSpec = RestAssured.given();

       //specify URL
       requestSpec.baseUri("https://httpbin.org/post");

       requestSpec.multiPart("file",Test_Upload_file);

       //perform Post request
       Response response = requestSpec.post();

       //print response body
       response.prettyPrint();

       //validate the response status code
       Assert.assertEquals(response.getStatusCode() ,200 , "Response code validated");


   }
}
