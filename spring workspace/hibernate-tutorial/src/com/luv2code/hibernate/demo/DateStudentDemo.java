package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.date.DateUtils;
import com.luv2code.hibernate.demo.entity.Student;

public class DateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			String dateOfBirth = "31/12/1998";
			Date parsedDate = DateUtils.parseDate(dateOfBirth);
			Student student = new Student("Arnold", "Osorio", "aosorio@gmail.com", parsedDate);
			session.save(student);
			
			session.getTransaction().commit();
		} catch(Exception e) { 
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
