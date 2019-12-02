package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 1);
			// updates hb-student-tracker table
			student.setEmail("joliverestampador@gmail.com");
			
			System.out.println(student);
			
			session.getTransaction().commit();
			
			// new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='foo.gmail.com'")
				.executeUpdate();
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
