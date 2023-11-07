package com.abhishek.thymeleafdemo.controller;

import com.abhishek.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${favoriteProgrammingLanguages}")
    private List<String>favoriteProgrammingLanguages;

    @Value("${systems}")
    private List<String>operatingSystems;

    @GetMapping(path = "/showStudentForm")
    public String showStudentForm(Model theModel) {

        Student theStudent = new Student();
//        theStudent.setFirstName("Levis");
//        theModel.addAttribute("studentFirstName",theStudent.getFirstName());
        theModel.addAttribute("student", new Student());

        theModel.addAttribute("countries",countries);

        theModel.addAttribute("favoriteProgrammingLanguages",favoriteProgrammingLanguages);

        theModel.addAttribute("operatingSystems",operatingSystems);

        return "student-form-two";
    }

    @PostMapping(path = "/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student thestudent) {
        System.out.println("First Name: " + thestudent.getFirstName());

        return "student-confirmation-page";

    }

}
