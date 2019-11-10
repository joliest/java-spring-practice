package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
//		demonstrate prototype bean
		Coach theCoach = context.getBean("myCoach", Coach.class);		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nPointing to the same object" + result);
		System.out.println("\nMemory Location for the coach" + theCoach);
		System.out.println("\nMemory Location for the alpaCoach" + alphaCoach);
		
		context.close();
	}

}
