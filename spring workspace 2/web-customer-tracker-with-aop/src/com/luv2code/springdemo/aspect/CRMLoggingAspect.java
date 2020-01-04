package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	// setup logger
	private Logger logger = Logger.getLogger(getClass().getName());

	// setup pointcut declaration 
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}

	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// combining pointcut
	@Pointcut("forControllerPackage() || forServicePackage () || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		// display method we are calling
		String method = joinPoint.getSignature().toShortString();
		logger.info("=====> in @Before: calling method: " + method);
		
		// display the arguments to the method
		
		// get arguments to teh method
		Object[] args = joinPoint.getArgs();
		
		// get the arguments
		for(Object tempArg: args) {
			logger.info("=====> argument: " + tempArg);
		}
		
	}
	
	// add @AfterReturning aspect
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint joinPoint, Object theResult) {
		// display method we are returning from 
		String method = joinPoint.getSignature().toShortString();
		logger.info("=====> in @AfterReturning: from method: " + method);
		
		// display data returned
		logger.info("=====> result: " + theResult);
		
	}
}


















