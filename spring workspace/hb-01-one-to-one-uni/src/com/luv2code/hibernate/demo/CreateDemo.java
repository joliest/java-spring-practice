package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			/*
			 
			Instructor instructor = 
					new Instructor("Joli", "Estampador", "joliver@gmail.com");
			
			InstructorDetail instructorDetail = 
					new InstructorDetail("http://yourube.com/jejemons", "Series");
			
			instructor.setInstructorDetail(instructorDetail);
			
			*/
			
			Instructor instructor = 
					new Instructor("Dudu", "Popoy", "doggy@gmail.com");
			
			InstructorDetail instructorDetail = 
					new InstructorDetail("http://yourube.com/luv2code", "Baby ko");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			// this will alsos ave the details object because of CascadeType.ALL
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
