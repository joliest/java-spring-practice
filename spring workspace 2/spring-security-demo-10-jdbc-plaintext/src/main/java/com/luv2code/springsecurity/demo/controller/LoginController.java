package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "fancy-login";
	}
	
	@GetMapping("/")
	public String showLanding() {
		return "landing";
	}
	
	@GetMapping("/employees")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
