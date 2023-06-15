package com.myspringbootproject.springcoredemo.controller;

import com.myspringbootproject.springcoredemo.model.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShapeController {

    private Shape shape;



    @Autowired
    public ShapeController(@Qualifier("aquatic")Shape shape){
        this.shape=shape;
        System.out.println("In Constructor: " +getClass().getSimpleName());

    }

    @GetMapping(path = "/getArea")
    public String calculateArea(){

       return "Area of rectangle: " + shape.calculateArea();

    }

    @GetMapping(path = "/hello")
    public String Hello(){

        return "Hello";

    }

}
