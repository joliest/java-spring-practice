package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger = 
			Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = 
				context.getBean(TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemo App");
		myLogger.info("\nCalling getFortune()");
		
		// triggers the exception
		boolean tripWire = true;
		myLogger.info("\nThe Fortune is: " + trafficFortuneService.getFortune(tripWire));
		
		context.close();
	}
}
