package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor instructor = 
					new Instructor("Chad", "Doffy", "chad@gmail.com");
			
			InstructorDetail instructorDetail = 
					new InstructorDetail("http://www.youtube.com", "Video games");
			
			instructor.setInstructorDetail(instructorDetail);

			
			session.beginTransaction();
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
