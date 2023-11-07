package com.abhishek.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api")
public class EmployeeController {
//browser always submit GET request by default
    @GetMapping(path = "/showEmployeeForm")
    public String showEmployeeForm() {
        return "employee-form";
    }


    @PostMapping(path = "/processEmployeeForm")
    public String processEmployeeForm() {
        return "employee-confirmation-page";
    }


}
