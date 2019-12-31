package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// print out method we're advising on
		String signature = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("====>>> Executing @Around on " + signature);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// lets execute the method
		Object result = proceedingJoinPoint.proceed();
		
		// get end time stamp
		long end = System.currentTimeMillis();
		
		// compute and display timestamp
		long duration = end - begin;
		System.out.println("\n =====> Duration " + duration / 1000.0 + " seconds");
		
		// should return object
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n\n =====> Executing @After : " + joinPoint.getSignature().toShortString());
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccoundAdvice(JoinPoint jointPoint,
												Throwable theExc) {
		System.out.println("\n\n =====> @AfterThrowing : " + jointPoint.getSignature().toShortString());
		
		// log the exception
		System.out.println("\n =====> Exception: " + theExc);
	}
	
	@Before("com.luv2code.aopdemo.aspect.AopExpresions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("2) ====>>> Executing @Before advise on addAccount");

		// display the method signature
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method signature: " + signature);
		
		// display method arguments
		Object[] objects = joinPoint.getArgs();
		
		for(Object obj : objects) {
			System.out.println("Object: " + obj);
			
			if (obj instanceof Account) {
				// downcast and print Account
				Account account = (Account) obj;
				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
			}
		}
	}
	
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
					returning="result")
	public void afterReturningAddAccountAdvice(JoinPoint joinPoint, List<Account> result) {
		System.out.println("\n =====> After @AfterReturning: " + joinPoint.getSignature());

		System.out.println("\n\n =====> result is: " + result);
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n\n =====> upper case name : " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop thru accounts
		for(Account account : result) {
			// get upper case
			String upperName = account.getName().toUpperCase();
			
			// update the name of account
			account.setName(upperName);
		}
	}
}
