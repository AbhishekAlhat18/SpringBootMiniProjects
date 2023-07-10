package com.restcrudapi.demo.service.implementation;

import com.restcrudapi.demo.exceptions.StudentNotFoundException;
import com.restcrudapi.demo.model.Student;
import com.restcrudapi.demo.service.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private List<Student> studentList = new ArrayList<>();


//    public StudentServiceImpl() {
//        System.out.println("StudentServiceImpl constructor is running..");
//        createStudentList();
//    }

    //Instead of using above constructor and calling method createList()
    //inside constructor we can also use PostConstruct to
    //run this once post this class is constructed.

    @PostConstruct
    private void loadData(){
        System.out.println("Inside Post Construct..");
        studentList.add(new Student(101, "John", "Doe"));
        studentList.add(new Student(102, "Scarlett", "Witch"));
        studentList.add(new Student(103, "Chris", "Hemsworth"));
        studentList.add(new Student(104, "Margot", "Robbie"));
        studentList.add(new Student(105, "Alicia", "vikander"));
    }





//    private List<Student> createStudentList(){
//        studentList.add(new Student(101, "John", "Doe"));
//        studentList.add(new Student(102, "Scarlett", "Witch"));
//        studentList.add(new Student(103, "Chris", "Hemsworth"));
//        studentList.add(new Student(104, "Margot", "Robbie"));
//        return studentList;
//
//    }


    @Override
    public List<Student> getAllStudents() {

        return studentList;

    }

    @Override
    public Student getById(int Id) {
        //createStudentList();
        boolean studentFound = false;
        Student foundStudent = new Student();
        for (Student student : studentList) {
            if (student.getRollNumber() == Id) {
                studentFound = true;
                foundStudent = student;
            }
        }
        if (studentFound==false){
            throw new StudentNotFoundException("Student with id " +Id+ " not found!");

        }

        return foundStudent;



    }
}
