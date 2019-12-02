package com.luv2code.hibernate.exercise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeletingEmployeeById {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			System.out.println("\n Deleting id 3");
			Employee emp = session.get(Employee.class, 3);
			
			session.delete(emp);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
