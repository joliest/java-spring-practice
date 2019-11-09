package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach theBasketballCoach = context.getBean("basketballCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theBasketballCoach.getDailyWorkout());
		
		// close the context
		context.close();
	}

}
