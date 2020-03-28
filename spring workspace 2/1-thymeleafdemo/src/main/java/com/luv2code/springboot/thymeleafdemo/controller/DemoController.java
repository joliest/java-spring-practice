package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("date", new java.util.Date());
		
		// will automatically look for resources/template
		return "helloworld";
	}
}
