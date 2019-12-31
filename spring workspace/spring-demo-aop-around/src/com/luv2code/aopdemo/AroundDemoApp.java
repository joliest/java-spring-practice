package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = 
				context.getBean(TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundDemo App");
		System.out.println("\nCalling getFortune()");
		System.out.println("\nThe Fortune is: " + trafficFortuneService.getFortune());
		
		context.close();
	}
}
