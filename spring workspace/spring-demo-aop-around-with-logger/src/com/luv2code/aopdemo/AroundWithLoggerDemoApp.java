package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = 
				context.getBean(TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemo App");
		myLogger.info("\nCalling getFortune()");
		myLogger.info("\nThe Fortune is: " + trafficFortuneService.getFortune());
		
		context.close();
	}
}
