package POJO;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class JSONArrayPOJOclassDemo {

    @Test
    public void createEmployeeJSONArray() throws JsonProcessingException {
        Employee emp1 = new Employee();

        emp1.setFirstname("Suresh");
        emp1.setLastname("kumar");
        emp1.setGender("Male");
        emp1.setAge(29);
        emp1.setSalary(35000);

        Employee emp2 = new Employee();

        emp2.setFirstname("Ram");
        emp2.setLastname("singh");
        emp2.setGender("Male");
        emp2.setAge(49);
        emp2.setSalary(45000);

        Employee emp3 = new Employee();
        emp3.setFirstname("sita");
        emp3.setLastname("gupta");
        emp3.setGender("Female");
        emp3.setAge(19);
        emp3.setSalary(55000.55);


        List<Employee> listofEmp = new ArrayList<Employee>();
        listofEmp.add(emp1);
        listofEmp.add(emp2);
        listofEmp.add(emp3);


        //convert employee class object to json array payload

        ObjectMapper objmapper = new ObjectMapper();

        String jsonArrayPayLoad = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(listofEmp);

        //Print JSON array
        System.out.println("Array is : " + jsonArrayPayLoad);
    }
}
