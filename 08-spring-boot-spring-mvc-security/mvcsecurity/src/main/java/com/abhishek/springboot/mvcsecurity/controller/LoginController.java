package com.abhishek.springboot.mvcsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/api")
public class LoginController {


    @GetMapping("/showLoginFormPage")
    public String showLoginFormPage(){
        return "login-page";
    }



}
