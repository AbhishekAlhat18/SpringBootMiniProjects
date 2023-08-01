package com.springbootbasics.cruddemo;

import com.springbootbasics.cruddemo.dao.ApiResponseEntity;
import com.springbootbasics.cruddemo.dao.StudentDAO;
import com.springbootbasics.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.Date;




@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CruddemoApplication.class, args);

		java.sql.Date  newUtilDate = new java.sql.Date (new java.util.Date().getTime());
		int year = 2023;
		int month = 6; // January is month 0, so June is month 5
		int day = 25;

		// Create a Calendar instance
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(year, month, day);

		// Get the Date object
		Date specificDate = calendar.getTime();
		System.out.println("Util Date: " + specificDate);

		// Convert newUtilDate to java.sql.Date
		java.sql.Date specificSqlDate = new java.sql.Date(specificDate.getTime());
		java.sql.Date newSqlDate = new java.sql.Date (newUtilDate.getTime());
		System.out.println("specificSqlDate" +specificSqlDate);
		System.out.println("newSqlDate" +newSqlDate);

		LocalDate dbdate = specificSqlDate.toLocalDate();
		LocalDate newDate = newSqlDate.toLocalDate();

		// Compare the dates
		if (dbdate.isBefore(newDate)) {
			System.out.println(newSqlDate + " is before " + specificSqlDate);
		} else if (dbdate.isAfter(newDate)) {
			System.out.println(newSqlDate + " is after " + specificSqlDate);
		} else {
			System.out.println(specificSqlDate + " is equal to " + specificSqlDate);
		}


	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return (runner)->{
			createMultipleStudents(studentDAO);
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

	private void createMultipleStudents(StudentDAO studentDAO){

		//Create Multiple Student
		System.out.println("Creating Multiple Students");
		Student student1 = new Student("Scarlett","Sinn","scarlett@yahoo.com");
		Student student2 = new Student("Elena","Sinn","Elena@yahoo.com");

		//Saving students
		System.out.println("Saving Multiple Students");
		studentDAO.save(student1);
		studentDAO.save(student2);

		//Printing students
		System.out.println(student1);
		System.out.println(student2);
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
		int studentId = 1;
		Student response = studentDAO.findById(studentId);
		System.out.println("Retrieved Student : \n" +response);

		//Update firstname of retrieved student
		System.out.println("Updating firstname of retrieved student...:");
		response.setFirstName("Silly");

		//Save and update in database
//		studentDAO.update(response);
//		Student responseUpdated = studentDAO.findById(4);
//		System.out.println("Updated Student : \n" +responseUpdated);

		try {
			studentDAO.update(response);
			System.out.println("Success");
		} catch (RuntimeException exc) {
			System.out.println("Failure");
			System.out.println("Message: " +exc.getMessage());
			exc.printStackTrace();
		}





	}





}
