package com.springbootbasics.cruddemo.dao;

import com.springbootbasics.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer Id);

    ApiResponseEntity findAll();

     List<Student>findByLastName(String theLastName);
}
