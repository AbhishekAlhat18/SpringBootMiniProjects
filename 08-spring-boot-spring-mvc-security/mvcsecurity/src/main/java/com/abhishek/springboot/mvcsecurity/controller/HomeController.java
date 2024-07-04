package com.abhishek.springboot.mvcsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/api")
public class HomeController {

    @GetMapping("/")
    public String homePage(){
        return "homepage";
    }

    @RequestMapping("/leaders")
    public String leadershipRetreatPage(){
        return "leadership-retreat-page";
    }

    @RequestMapping("/systems")
    public String adminHolidayPage(){
        return "admin-holiday-page";
    }


}
