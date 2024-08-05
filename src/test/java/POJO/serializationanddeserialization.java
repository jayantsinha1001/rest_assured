package POJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class serializationanddeserialization {

    @Test
    public void createJSONObjectFromEmployeeClassObject() throws JsonProcessingException {

        Employee emp1 = new Employee();
        emp1.setFirstname("shayam");
        emp1.setLastname("kumar");
        emp1.setGender("Male");
        emp1.setAge(25);
        emp1.setSalary(5000);

        ObjectMapper objectmapper = new ObjectMapper();
        String empInJSON = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

        System.out.println(empInJSON);

        //Create Request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //specify URL and perform post request
        requestSpec.baseUri("https://httpbin.org/post");
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(empInJSON);
        Response response =  requestSpec.post();

        response.prettyPrint();

        //validate status code
        Assert.assertEquals(response.getStatusCode(), 200 );

        //convert JSON string to class object

        Employee emp2 = objectmapper.readValue(empInJSON , Employee.class);


        System.out.println("------- Print after JSON Object to Class Object-------");
        System.out.println("FirstName : " + emp2.getFirstname());
        System.out.println("LastName : " + emp2.getLastname());
        System.out.println("Gender : " + emp2.getGender());
        System.out.println("Age : " + emp2.getAge());
        System.out.println("Salary : " + emp2.getSalary());

    };
    }

