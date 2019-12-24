package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int maryId = 2;
			Student mary = session.get(Student.class, maryId);
			
			System.out.println("\n Loaded student: " + mary);
			System.out.println("\n Courses: " + mary.getCourses());
			
			Course course1 = new Course("Rubik's Cube - How to speed up");
			Course course2 = new Course("Atari 2600 - Game Development");
			
			course1.addStudent(mary);
			course2.addStudent(mary);
			
			System.out.println("\n Saving courses . . . ");
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
			
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}
	}

}
