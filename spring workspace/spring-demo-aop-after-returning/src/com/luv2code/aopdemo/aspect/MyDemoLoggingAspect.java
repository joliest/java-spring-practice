package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
