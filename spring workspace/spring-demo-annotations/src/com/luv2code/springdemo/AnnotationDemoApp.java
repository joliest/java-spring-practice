package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theSillyCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println(theSillyCoach.getDailyWorkout());
		System.out.println(theSillyCoach.getDailyFortune());
		
		context.close();
	}
}
