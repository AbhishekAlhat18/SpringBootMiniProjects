package com.restcrudapi.demo.service;

import com.restcrudapi.demo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getById(int Id);

    Student addStudent(Student student);
}
