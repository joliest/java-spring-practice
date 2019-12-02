package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			/*
			session.beginTransaction();
			
			Student student = session.get(Student.class, 1);
			System.out.println("Deleting a row in Student table");
			session.delete(student);
			
			session.getTransaction().commit();
			*/
			
			// New Code
			session.beginTransaction();
			
			System.out.println("Deleting via H-SQL");
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
