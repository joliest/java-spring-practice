package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// save Java object
			Student myStudent = new Student("Paul", "wall", "foo@gmail.com");
			// start a transaction
			session.beginTransaction();
			
			// save student Object
			session.save(myStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
