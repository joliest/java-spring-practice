package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// add all related advices for logging
	
	// start wth @Before advise
	
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advise on addAccount");
	}
}
