package com.myspringbootproject.springcoredemo.Model;

import org.springframework.stereotype.Component;

@Component
public class Square implements Shape {
    private double side = 6.0;



    @Override
    public double calculateArea() {
        return side * side;
    }
}
