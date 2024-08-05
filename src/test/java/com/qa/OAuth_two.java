package com.qa;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class OAuth_two {

    @Test
    public void OAuth_TWo(){

        String client_ID = "AUSiqvYfMGQ0fPrEANyiFN_3YmeTQiLWqzMlJAy0bvfe6XoXUKYQWcMaMYwNqFGB34wdeWzrJGMVJzET";
        String client_secret = "EJjpu0LjfTB8GoR7ZDpe715OGgmkBJS3Kdf2nxgDKxcs2WcblxkAihhYZNH3xx-o2BsgERyzaGzTL6tx";

        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.baseUri("https://api-m.sandbox.paypal.com");
        requestSpec.basePath("/v1/oauth2/token");

       Response response = (Response) requestSpec.auth().preemptive().basic(client_ID ,client_secret).param("grant_type","client_credentials");

        response.prettyPrint()

        ;
    }

}
