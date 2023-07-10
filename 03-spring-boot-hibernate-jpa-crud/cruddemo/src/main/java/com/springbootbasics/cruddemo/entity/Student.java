package com.springbootbasics.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Student() {

    }

    public Student( String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;


    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        System.out.println("getter for firstName is called...");
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println("setter for firstName is called: "+firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        System.out.println("getter for lastName is called...");
        return lastName;
    }

    public void setLastName(String lastName) {
        System.out.println("setter for lastName is called: "+lastName);
        this.lastName = lastName;
    }

    public String getEmail() {
        System.out.println("getter for email is called...");
        return email;
    }

    public void setEmail(String email) {
        System.out.println("setter for email is called: "+email);
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
