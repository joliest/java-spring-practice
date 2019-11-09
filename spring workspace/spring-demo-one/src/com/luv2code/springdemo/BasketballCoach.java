package com.luv2code.springdemo;

public class BasketballCoach implements Coach{
	
	@Override
	public String getDailyWorkout() {
		return "Dribble 100x in 60 minutes";
	}
}
