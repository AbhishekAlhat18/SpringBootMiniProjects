package com.myspringbootproject.springcoredemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Circle implements Shape{

    private double radius = 7.0;

    @Override
    public double calculateArea() {
        return 3.14 *radius*radius;
    }
}
