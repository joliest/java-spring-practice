package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AdterThrowingDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		
		List<Account> accounts = null;
		
		try {
			// simulating exception
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
			
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
