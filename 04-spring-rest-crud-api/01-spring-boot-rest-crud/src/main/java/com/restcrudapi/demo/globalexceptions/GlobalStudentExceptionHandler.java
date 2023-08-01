package com.restcrudapi.demo.globalexceptions;

import com.restcrudapi.demo.errorresposne.StudentErrorResponse;
import com.restcrudapi.demo.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalStudentExceptionHandler {

//    @ExceptionHandler
//    private ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException exc){
//
//        StudentErrorResponse errorResponse = new StudentErrorResponse();
//
//        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        errorResponse.setMessage(exc.getMessage());
//        errorResponse.setTimestamp(System.currentTimeMillis());
//
//        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
//
//    }


    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse>handleException(Exception exc){
        StudentErrorResponse errorResponse = new StudentErrorResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);


    }
}
