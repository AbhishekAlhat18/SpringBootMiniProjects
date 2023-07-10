package com.restcrudapi.demo.controller;

import com.restcrudapi.demo.model.Student;
import com.restcrudapi.demo.service.implementation.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class StudentRestController {

    private StudentServiceImpl studentService;

    public StudentRestController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/students")
    @ResponseBody
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();

    }
    @GetMapping("/students/{rollNumber}")
    @ResponseBody
    public Student getStudentById(@PathVariable("rollNumber") int Id ){
        return studentService.getById(Id);
    }

    @GetMapping("/example")
    public ResponseEntity<String> handleOptionalRequestParam(
            @RequestParam(required = false) String optionalVariable) {
        if (optionalVariable != null) {
            // Path variable is present
            return ResponseEntity.ok("Path variable value: " + optionalVariable);
        } else {
            // Path variable is not present
            return ResponseEntity.ok("Path variable is not provided");
        }

    }




}
