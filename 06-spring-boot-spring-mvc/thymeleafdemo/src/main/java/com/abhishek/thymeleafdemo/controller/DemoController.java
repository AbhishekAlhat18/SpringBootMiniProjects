package com.abhishek.thymeleafdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping(path = "/hello")
    public String sayHello(Model themodel){

        themodel.addAttribute("theDate",new java.util.Date());

        return "thymeleafDemo";

    }

}
