package com.myspringbootproject.springcoredemo.model;

import com.myspringbootproject.springcoredemo.model.Shape;
import org.springframework.stereotype.Component;

@Component
public class Square implements Shape {
    private double side = 7.0;

    public Square() {
        System.out.println("In Constructor: " +getClass().getSimpleName());
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}
