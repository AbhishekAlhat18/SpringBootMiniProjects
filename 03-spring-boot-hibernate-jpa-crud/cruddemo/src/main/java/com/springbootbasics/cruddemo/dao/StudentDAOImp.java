package com.springbootbasics.cruddemo.dao;

import com.springbootbasics.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public void save(Student student) {
        entityManager.persist(student);

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
                "FROM Student WHERE lastname = :Data", Student.class);
        theQuery.setParameter("Data", theLastName);
        List<Student> student =  theQuery.getResultList();
        response.setMessage("Request Successful");
        response.setStatus(HttpStatus.OK);
        response.setStatusCode(HttpStatus.OK.value());
        response.setResponseBody(student);
        return response;

    }

}
