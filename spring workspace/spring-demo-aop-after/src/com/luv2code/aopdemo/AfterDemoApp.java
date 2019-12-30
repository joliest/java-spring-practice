package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		
		List<Account> accounts = null;
		
		try {
			// simulating exception
//			boolean tripWire = true; // uncomment if need to test with Exceptions
			accounts = accountDAO.findAccounts(false);
			
		} catch (Exception exc) {
			System.out.println("\n\nMain Program ... caught exception: " + exc);
		}
		
		System.out.println("\n\n Main Program: AfterThrowingDemoApp");
		System.out.println("----");
		System.out.println(accounts);
		System.out.println("\n");
		
		context.close();
	}
}
