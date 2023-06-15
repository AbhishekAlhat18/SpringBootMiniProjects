package com.myspringbootproject.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class Square implements Shape{
    private double side = 6.0;

    public Square() {
        System.out.println("In Constructor: " +getClass().getSimpleName());
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}
