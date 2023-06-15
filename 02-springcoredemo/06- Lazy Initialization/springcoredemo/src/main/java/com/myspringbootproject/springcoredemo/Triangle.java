package com.myspringbootproject.springcoredemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle() {
        System.out.println("In Constructor: " +getClass().getSimpleName());
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return (base * height) / 2;
    }
}

