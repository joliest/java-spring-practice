package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
//		demonstrate prototype bean
		Coach theCoach = context.getBean("myCoach", Coach.class);		
		System.out.println(theCoach.getDailyWorkout());
		context.close();
	}

}
