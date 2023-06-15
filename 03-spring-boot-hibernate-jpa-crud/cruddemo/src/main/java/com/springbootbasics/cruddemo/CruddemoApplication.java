package com.springbootbasics.cruddemo;

import com.springbootbasics.cruddemo.dao.ApiResponseEntity;
import com.springbootbasics.cruddemo.dao.StudentDAO;
import com.springbootbasics.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CruddemoApplication.class, args);


	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return (runner)->{
			updateStudentById(studentDAO);

		};

	}

	private void createStudent(StudentDAO studentDAO) {

		//Create Student
//		System.out.println("Creating student...:");
//		Student studentObject = new Student("Scarlett","Sinn","sacrlettsinn@hotmail.com");
////
////		//Save Student
//		System.out.println("Saving student...:");
//		studentDAO.save(studentObject);
////
////		//getId of student
//		System.out.println("Fetching id of the saved student...:");
//		System.out.println("Id: " +studentObject.getId());

		//retrieve student by id: primary key
//		System.out.println("Retrieving student by id...:");
//		Student student = studentDAO.findById(4);

		//printing student
//		System.out.println("Student : \n" +student);


	}

	private void getAllStudents(StudentDAO studentDAO){
		//get All student list
		System.out.println("Retrieving all students...:");
		System.out.println(studentDAO.findAll());

	}

	private void getByName(StudentDAO studentDAO){
		System.out.println("Retrieving  students by name...:");
		ApiResponseEntity cmdResponse = studentDAO.findStudentByLastName("Doe");
		System.out.println(cmdResponse);
	}

	private void updateStudentById(StudentDAO studentDAO){
		//Retrieve student using Id;
		System.out.println("Retrieving student using id...:");
		Student response = studentDAO.findById(4);
		System.out.println("Retrieved Student : \n" +response);

		//Update firstname of retrieved student
		System.out.println("Updating firstname of retrieved student...:");
		response.setFirstname("Rhodes");

		//Save and update in database
//		studentDAO.update(response);
//		Student responseUpdated = studentDAO.findById(4);
//		System.out.println("Updated Student : \n" +responseUpdated);

		try {
			studentDAO.update(response);
			System.out.println("Success");
		} catch (RuntimeException ex) {
			System.out.println("Failure");
			ex.printStackTrace();
		}

	}
}
