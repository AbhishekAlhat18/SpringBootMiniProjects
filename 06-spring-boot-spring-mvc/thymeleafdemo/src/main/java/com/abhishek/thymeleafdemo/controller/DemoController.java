package com.abhishek.thymeleafdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping(path = "/date")
    public String displayDate(Model themodel){

        themodel.addAttribute("theDate",new java.util.Date());

        return "thymeleafDemo";
//        Spring will automatically add .html to return String

    }

    @GetMapping(path = "/hello")
    public String sayHello(Model theModel){
        String firstName = "John";
//      theModel.addAttribute can be used to set data which can be used in HTML view in thymeleaf templates
        theModel.addAttribute("theFirstName",firstName);

        return "john";
    }

}
