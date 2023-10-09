package com.springbootbasics.cruddemo.dao;

import com.springbootbasics.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Repository
public class StudentDAOImp implements StudentDAO {


    //define field for Entity Manager
    private EntityManager entityManager;


    //inject entityManager using constructor injection
    @Autowired
    public StudentDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    //Implement save method
    @Override
    @Transactional
    public ApiResponseEntity save(Student student) {
        ApiResponseEntity response = new ApiResponseEntity();
        entityManager.persist(student);
        response.setMessage("Student Added Successfully");
        response.setStatus(HttpStatus.OK);
        response.setStatusCode(HttpStatus.OK.value());
        response.setResponseBody(student);
        return response;

    }

    //Implement find method
    @Override
    public Student findById(Integer Id) {
        return entityManager.find(Student.class, Id);

    }

    @Override
    public ApiResponseEntity findAll() {
        ApiResponseEntity response = new ApiResponseEntity();
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        List<Student> studentList = theQuery.getResultList();
        response.setMessage("Request Successful");
        response.setStatus(HttpStatus.OK);
        response.setStatusCode(HttpStatus.OK.value());
        response.setResponseBody(studentList);
        return response;

    }

    @Override
    public ApiResponseEntity findStudentByLastName(String theLastName) {
        ApiResponseEntity response = new ApiResponseEntity();
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName = :Data", Student.class);
        theQuery.setParameter("Data", theLastName);
        List<Student> student =  theQuery.getResultList();
        response.setMessage("Request Successful");
        response.setStatus(HttpStatus.OK);
        response.setStatusCode(HttpStatus.OK.value());
        response.setResponseBody(student);
        return response;

    }

    @Override
    @Transactional
    public void update(Student student) throws RuntimeException {
        entityManager.merge(student);

    }

    @Override
    @Transactional
    public ApiResponseEntity delete(int Id) {
        ApiResponseEntity response = new ApiResponseEntity();
        Student student = entityManager.find(Student.class,Id);
        entityManager.remove(student);
        response.setMessage("Student Deleted Successfully");
        response.setStatus(HttpStatus.OK);
        response.setStatusCode(HttpStatus.OK.value());
        response.setResponseBody(student);
        return  response;
    }

    @Override
    @Transactional
    public ApiResponseEntity deleteAllStudents() {
        ApiResponseEntity response = new ApiResponseEntity();

        int deletedRows = entityManager.createQuery("DELETE FROM Students").executeUpdate();
        response.setMessage("All records deleted successfully");
        response.setStatus(HttpStatus.OK);
        response.setStatusCode(HttpStatus.OK.value());
        response.setResponseBody(null);
        return response;

    }




}
