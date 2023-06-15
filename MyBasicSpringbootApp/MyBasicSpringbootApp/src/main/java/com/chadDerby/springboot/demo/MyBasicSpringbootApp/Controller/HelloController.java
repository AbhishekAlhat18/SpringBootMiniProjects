package com.chadDerby.springboot.demo.MyBasicSpringbootApp.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

@Value("${employee.name}")
private String employeeName;

@Value("${employee.id}")
private int employeeId;


@RequestMapping(path = "/",method = RequestMethod.GET)
private String SayHello(){
    return "Hello World!!!";
    }

@GetMapping(path = "/get")
public String getName(){
    return "Virat Kolhi";
}
@GetMapping("/getEmployeeDetails")
public String getEmployeeName(){
    return "Employee Name : <b>" +employeeName + "</b><br>Employee Id : <b>" +employeeId +"</b>" ;
}


}
