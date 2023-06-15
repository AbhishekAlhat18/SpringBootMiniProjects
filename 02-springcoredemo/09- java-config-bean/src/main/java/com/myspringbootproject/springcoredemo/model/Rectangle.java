package com.myspringbootproject.springcoredemo.model;

public class Rectangle implements Shape {
    private double length = 7;
    private double width = 8;

    public Rectangle() {
        System.out.println("In Constructor: " +getClass().getSimpleName());
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
