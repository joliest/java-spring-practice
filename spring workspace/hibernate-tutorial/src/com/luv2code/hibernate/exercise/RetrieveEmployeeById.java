package com.luv2code.hibernate.exercise;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class RetrieveEmployeeById {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Employee employee = session.get(Employee.class, 1);
			System.out.println("\nGetting employee by Id: 1");
			System.out.println("Employee name: " + employee.getFirstName());
			
			List<Employee> employees = session.createQuery("from Employee e "
					+ "where e.firstName = 'Clarice'").getResultList();
			System.out.println("Employees named Clarice \n" + employees);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
