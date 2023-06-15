package com.myspringbootproject.springcoredemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Circle implements Shape{

    private double radius = 3.0;

    public Circle() {
        System.out.println("In Constructor: " +getClass().getSimpleName());
    }

    @Override
    public double calculateArea() {
        return 3.14 *radius*radius;
    }
}
