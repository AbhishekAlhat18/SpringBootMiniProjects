package com.abhishek.springdemo.mvc.controller;

import com.abhishek.springdemo.mvc.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class StudentController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping(path = "/studentForm")
    public String showStudentForm(Model theModel) {

        theModel.addAttribute("student", new Student());

        return "student-form";

    }


    @PostMapping(path = "/processStudentForm")
    public String processStudentForm(@Valid @ModelAttribute("student") Student theStudent, BindingResult bindingResult) {

        System.out.println("bindingResult: " +bindingResult.toString());

        System.out.println("\n\n\n");

        System.out.println("Last Name: |"+ theStudent.getLastName()+ "|");
        if (bindingResult.hasErrors()){
            return "student-form";
        }else {
            return "student-confirmation-page";
        }


    }

}
