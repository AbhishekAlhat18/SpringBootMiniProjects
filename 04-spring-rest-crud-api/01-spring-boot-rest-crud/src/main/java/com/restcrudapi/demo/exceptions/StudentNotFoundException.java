package com.restcrudapi.demo.exceptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }


}
