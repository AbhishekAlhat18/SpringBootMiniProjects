package com.abhishek.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/students")
public class HelloWorldController {

    @GetMapping(path = "/showForm")
    public String showForm() {

        return "student-form";
    }

    @PostMapping(path = "/processForm")
    public String processForm(HttpServletRequest request, Model theModel) {
//        System.out.println("Name of student: " + studentName);

//      String studentNameToUpperCase = studentName.toUpperCase();

        String theName = "Yo! " + request.getParameter("studentName");

        System.out.println(request.getParameter("studentName"));

        theModel.addAttribute("theStudentName", theName);

        return "confirmation-page";
    }

    @RequestMapping(path = "/processFormVersionTwo")
    public String processFormVersionTwo(@RequestParam(value = "studentName") String theName, Model theModel) {
//      System.out.println("Name of student: " + studentName);

        String studentNameToUpperCase = theName.toUpperCase();


        theModel.addAttribute("theStudentName", studentNameToUpperCase);

        return "confirmation-page";
    }

}
