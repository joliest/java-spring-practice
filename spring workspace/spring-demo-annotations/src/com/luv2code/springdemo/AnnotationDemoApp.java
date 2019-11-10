package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theSillyCoach = context.getBean("theSillyCoach", Coach.class);
		System.out.println(theSillyCoach.getDailyWorkout());
		
		context.close();
	}

}
