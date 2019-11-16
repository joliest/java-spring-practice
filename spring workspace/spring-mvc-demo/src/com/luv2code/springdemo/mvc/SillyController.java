package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
	/*
	 * Demonstrate when there's 
	 * conflicts with request mapping
	 */
	@RequestMapping("/showForm")
	public String showPage() {
		return "silly";
	}
	
}
