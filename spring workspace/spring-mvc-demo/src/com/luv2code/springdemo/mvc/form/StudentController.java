package com.luv2code.springdemo.mvc.form;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{coursesOptions}")
	private Map<String, String> coursesOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		Student student = new Student();
		model.addAttribute("coursesOptions", coursesOptions);
		model.addAttribute("student", student);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		
		return "student-confirmation";
	}
}
