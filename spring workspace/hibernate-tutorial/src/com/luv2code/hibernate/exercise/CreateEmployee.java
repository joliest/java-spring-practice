package com.luv2code.hibernate.exercise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployee {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Employee emman = new Employee("Immanuel", "Valle", "Twist Resources");
			Employee clarice = new Employee("Clarice", "Esguerra", "Cormant Inc");
			Employee khaye = new Employee("Khaye", "Gorres", "Phil Excel");
			
			session.beginTransaction();
			session.save(emman);
			session.save(clarice);
			session.save(khaye);
			
			session.getTransaction()
				.commit();
		} finally {
			factory.close();
		}
	}
}
