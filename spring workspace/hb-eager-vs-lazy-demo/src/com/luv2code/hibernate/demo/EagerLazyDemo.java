package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("DebugMode: Instructor: " + instructor);
			
			// retrieveing list of courses
			System.out.println("DebugMode: Courses: " + instructor.getCourses());
			
			session.getTransaction().commit();
			
			session.close();
			
			// retrieveing list of courses
			System.out.println(" \nDebugMode: Session is now closed: " + instructor.getCourses());
			
		} finally {
			factory.close();
		}
	}

}
