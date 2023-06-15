package com.myspringbootproject.springcoredemo.controller;

import com.myspringbootproject.springcoredemo.Shape;
import com.myspringbootproject.springcoredemo.Square;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShapeController {


    private Shape square;

    private Shape circle;

    private Shape shape;

    @Autowired
    public ShapeController(@Qualifier("square")Shape shape) {
        this.shape=shape;
    }

    @GetMapping(path = "/getArea")
    public String calculateArea(){



       return "Area of Square: " + shape.calculateArea();


    }

}
