package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		Account account = new Account();
		account.setName("Joliver");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		
		// get the bean
		MembershipDAO membership = context.getBean(MembershipDAO.class);
		membership.addSillyAccount();
		membership.goToSleep();
		
		// close context
		context.close();
	}
}
