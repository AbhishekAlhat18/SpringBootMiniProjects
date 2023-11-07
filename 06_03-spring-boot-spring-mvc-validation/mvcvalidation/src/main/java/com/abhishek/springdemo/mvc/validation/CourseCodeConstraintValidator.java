package com.abhishek.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();

    }

    @Override
    public boolean isValid(String theFormData, ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result;

        if (theFormData != null) {
            result = theFormData.startsWith(coursePrefix);
        } else {
            result = true;
        }


        return result;
    }
}
