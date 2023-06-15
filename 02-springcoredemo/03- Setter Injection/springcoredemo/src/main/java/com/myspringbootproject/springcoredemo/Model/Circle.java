package com.myspringbootproject.springcoredemo.Model;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {

    private double radius = 5.0;

    @Override
    public double calculateArea() {
        return 3.14 *radius*radius;
    }
}
