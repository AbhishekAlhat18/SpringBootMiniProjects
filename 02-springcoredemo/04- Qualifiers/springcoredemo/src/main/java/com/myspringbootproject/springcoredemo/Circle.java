package com.myspringbootproject.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape{

    private double radius = 3.0;

    @Override
    public double calculateArea() {
        return 3.14 *radius*radius;
    }
}
