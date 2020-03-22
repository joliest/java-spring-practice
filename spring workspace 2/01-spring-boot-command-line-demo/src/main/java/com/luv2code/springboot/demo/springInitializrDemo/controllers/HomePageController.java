package com.luv2code.springboot.demo.springInitializrDemo.controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
	
	// expose
	@GetMapping("/")
	public String homepage() {
		return "Hello World. time on server is " + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k run";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortuner() {
		return "Today is your lucky day!";
	}
}
