package com.myspringbootproject.springcoredemo.controller;

import com.myspringbootproject.springcoredemo.Shape;
import com.myspringbootproject.springcoredemo.Square;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShapeController {

    private Shape shape;



    @Autowired
    public ShapeController(@Qualifier("square")Shape shape){
        this.shape=shape;
        System.out.println("In Constructor: " +getClass().getSimpleName());

    }

    //Define init method

    @PostConstruct
    public void doStartUpStuff(){
        System.out.println("In doStartUpStuff: " +getClass().getSimpleName());
    }

    //Define destroy method

    @PreDestroy
    public void doCleanUpStuff(){
        System.out.println("In doCleanUpStuff: " +getClass().getSimpleName());
    }

    @GetMapping(path = "/getArea")
    public String calculateArea(){

       return "Area of Square: " + shape.calculateArea();

    }

}
