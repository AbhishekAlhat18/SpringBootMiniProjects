package com.abhishek.mvc.ValidationDemo.Model;

import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 2,message = "expecting length more than 2 characters")
    @Pattern(regexp = "^[a-zA-z]+$",message = "should contain only letters")
    private String lastName;

    @NotNull(message = "is required")
    //|[0-9]|0[0-9])$",message = ("only valid Integers allowed"))
    @Min(value = 0,message = "Minimum value must be grater than or equal to 0")
    @Max(value = 10,message = "Maximum value must be greater than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-z0-9]{5}",message = "only 5 characters/digits allowed")
    private String postalCode;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Integer freePasses, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.freePasses = freePasses;
        this.postalCode = postalCode;
    }


    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
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
