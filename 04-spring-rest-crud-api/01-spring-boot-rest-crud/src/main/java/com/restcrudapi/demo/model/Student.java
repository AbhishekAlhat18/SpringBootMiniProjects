package com.restcrudapi.demo.model;

public class Student {
    private int rollNumber;
    private String firstName;
    private String lastName;

    //for foundStudent in getById() in StudentServiceImpl
    public Student() {
    }

    public Student(int rollNumber, String firstName, String lastName) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getRollNumber() {
        System.out.println("Getter for rollNumber called..."+this.rollNumber);
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        System.out.println("Setter for rollNumber called...");
        this.rollNumber = rollNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
