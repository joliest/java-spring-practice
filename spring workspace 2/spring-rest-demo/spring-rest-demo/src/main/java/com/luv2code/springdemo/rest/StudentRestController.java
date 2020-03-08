package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	// define @PostConstruct to load the student data .. will get called once
	@PostConstruct
	public void loadData() {
		// better approach because you load data once
		students = new ArrayList<>();

		students.add(new Student("Joliver", "Estampador"));
		students.add(new Student("Nathalie", "De Jesus"));
		students.add(new Student("Badette", "Smith"));
	}
	
	// define endpoint for "/students" - returns list of student
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}
	
	// define endpoint for /api/student/{studentId}
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if (studentId >= students.size() || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return students.get(studentId);
	}
	
	// handle errors / exception via StudentNotFoundException
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	// handle generic exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}








