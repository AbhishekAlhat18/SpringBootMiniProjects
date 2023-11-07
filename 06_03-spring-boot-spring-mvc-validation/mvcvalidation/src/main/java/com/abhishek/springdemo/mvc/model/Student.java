package com.abhishek.springdemo.mvc.model;

import com.abhishek.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Student {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1,message = "minimum size is 1")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0,message = "Minimum value should be not less than 0")
    @Max(value = 10,message = "Maximum value must be less than or equal to 10")
    private Integer freePasses;

    @NotNull(message = "is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 chars/numbers allowed")
    private String postalCode;

    @com.abhishek.springdemo.mvc.validation.CourseCode(value = "GOT",message = "must start with GOT")
    private String CourseCode;

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
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
