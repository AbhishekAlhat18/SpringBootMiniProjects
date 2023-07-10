package com.springbootbasics.cruddemo.controller;

import com.springbootbasics.cruddemo.dao.ApiResponseEntity;
import com.springbootbasics.cruddemo.dao.StudentDAOImp;
import com.springbootbasics.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentDAOImp studentDAOImp;

    @Autowired
    public StudentController(StudentDAOImp studentDAOImp){
        this.studentDAOImp = studentDAOImp;

    }

    @GetMapping(path = "/getAllStudents")
    public ResponseEntity<ApiResponseEntity> getAllStudents(){
        ApiResponseEntity response = studentDAOImp.findAll();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping(path = "/addStudent")
    public ApiResponseEntity saveStudent(@RequestBody Student student){
        ApiResponseEntity response = studentDAOImp.save(student);
        return response;
    }

    @GetMapping(path = "/getStudentByLastName/{studentName}")
    public ResponseEntity<ApiResponseEntity>getStudentByLastName(@PathVariable("studentName") String studentName){
        ApiResponseEntity response = studentDAOImp.findStudentByLastName(studentName);
        return ResponseEntity.status(response.getStatus()).body(response);

    }
    @GetMapping(path = "/deleteStudentById")
    public ResponseEntity<ApiResponseEntity> deleteStudentById(@RequestParam(value = "Id") int Id ){
        ApiResponseEntity response = studentDAOImp.delete(Id);
        return  ResponseEntity.status(response.getStatus()).body(response);
    }
}
