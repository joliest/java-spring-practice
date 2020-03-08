package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	// define endpoint for "/students" - returns list of student
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();

		students.add(new Student("Joliver", "Estampador"));
		students.add(new Student("Nathalie", "De Jesus"));
		students.add(new Student("Badette", "Smith"));
		
		return students;
	}
}
