package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);

		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		System.out.println("\nPointing to the same object: "+ result);
		System.out.println("\nMemory location for theCOach: "+ theCoach);
		System.out.println("\nMemory location for alphaCoach "+ alphaCoach);
		
		context.close();
	}

}
