package com.myspringbootproject.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class Square implements Shape{
    private double side = 4.0;



    @Override
    public double calculateArea() {
        return side * side;
    }
}
