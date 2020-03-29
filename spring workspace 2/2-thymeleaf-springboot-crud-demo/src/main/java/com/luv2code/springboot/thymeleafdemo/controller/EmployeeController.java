package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String showEmployees(Model model) {
		model.addAttribute("employees", employeeService.findAll());
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		
		// bind form data
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	
	/* Pre populates Update form */
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(
			@RequestParam("employeeId") int id, 
			Model model ) {
		// get the employee from service
		Employee employee = employeeService.findById(id);
		
		// set employee as a model attribute to prepopulate the form
		model.addAttribute("employee", employee);
		
		// send over to our form
		return "employees/employee-form";
	}
	
	@PostMapping("/save") 
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		// delete the employee
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}
