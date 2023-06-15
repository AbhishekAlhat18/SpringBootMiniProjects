package com.myspringbootproject.springcoredemo.controller;

import com.myspringbootproject.springcoredemo.Shape;
import com.myspringbootproject.springcoredemo.Square;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShapeController {




    private Shape shape1;
    private Shape shape2;


    @Autowired
    public ShapeController(@Qualifier("square")Shape shapeSquareOne,@Qualifier("square")Shape shapeSquareTwo) {
        System.out.println("In Constructor: " +getClass().getSimpleName());
        this.shape1=shapeSquareOne;
        this.shape2=shapeSquareTwo;
    }

    @GetMapping(path = "/getArea")
    public String calculateArea(){

       return "Area of Square: " + shape1.calculateArea() + "<br>Area of Triangle: "+shape2.calculateArea();

    }

    @GetMapping(path = "/check")
    public String check(){
        return "Comparing beans shape1==shape2: " +(shape1==shape2);
    }

}
