package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
public class EmployeeController {
	
	private List<Employee> employees;
	
	@PostConstruct
	private void loadData() {
		employees = Arrays.asList(
				new Employee(1, "Joliver", "Estampador"),
				new Employee(2, "Khaye", "Gorres"),
				new Employee(3, "Arlene", "Caguin")
		);
	}
	
	@GetMapping("/employees")
	public String showEmployees(Model model) {
		model.addAttribute("employees", employees);
		return "employees";
	}
}
