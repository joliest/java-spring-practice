package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	// injecting value from properties file
	@Value("${foo.email}")
	private String emailAddress;
	
	// field injection
	@Autowired
	@Qualifier("joliverFortuneService")
	private FortuneService fortuneService;
	
	// Constructor Injection
	/*	
  	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	} 
	*/

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune() + "\nEmail: " + this.emailAddress;
	}
	
	// Setter Injection
	/*
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	/*
	// Inject in some randome methods with dependency
	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	// define init method
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println(">> TennisCOach: inside of doMyStartUpStuff");
	}
	
	// define destroy methid
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println(">> TennisCoach: inside of doMyCLeanUpStuff");
	}
}
