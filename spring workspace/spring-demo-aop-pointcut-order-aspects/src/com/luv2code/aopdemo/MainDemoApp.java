package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		Account account = new Account();
		account.setName("Joliver");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		
		// call the accountdao getter/setter
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		MembershipDAO membership = context.getBean(MembershipDAO.class);
		membership.addSillyAccount();
		membership.goToSleep();
		
		context.close();
	}
}
