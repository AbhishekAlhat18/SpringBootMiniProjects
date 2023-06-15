package com.myspringbootproject.springcoredemo.controller;

import com.myspringbootproject.springcoredemo.Model.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShapeController {

    @Autowired
    private Shape square;

    @Autowired
    private Shape circle;

//    @Autowired
//    public void getBeans(Shape square, Shape circle) {
//        this.square = square;
//        this.circle = circle;
//    }

    @GetMapping(path = "/getArea")
    public String calculateArea(){

       return "Area of Square: " + square.calculateArea() +
               "<br> Area of Circle: " + circle.calculateArea();

    }

}
