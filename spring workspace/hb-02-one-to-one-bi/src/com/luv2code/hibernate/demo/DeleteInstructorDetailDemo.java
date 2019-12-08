package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int instructorDetailId = 3;
			InstructorDetail detail = 
					session.get(InstructorDetail.class, instructorDetailId);
			
			
			if(detail != null) {
				System.out.println("Deleting detail: " + detail);
				
				// remove association
				// break bi-drectional link
				detail.getInstructor().setInstructorDetail(null);
				
				session.delete(detail);
			}
			
			session.getTransaction().commit();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
