package com.myspringbootproject.springcoredemo.model;

import org.springframework.stereotype.Component;

@Component
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

