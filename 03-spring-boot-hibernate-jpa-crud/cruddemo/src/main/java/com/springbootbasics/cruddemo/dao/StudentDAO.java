package com.springbootbasics.cruddemo.dao;

import com.springbootbasics.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    ApiResponseEntity save(Student student);

    Student findById(Integer Id);

    ApiResponseEntity findAll();

    ApiResponseEntity findStudentByLastName(String theLastName);

    void update(Student student);

    ApiResponseEntity delete(int Id);

    ApiResponseEntity deleteAllStudents();
}
