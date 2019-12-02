package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").getResultList();
			
			// get list of students
			displayStudents(students);
			
			// query students: lastname = 'Caguin'
			students = session.createQuery("from Student s where s.lastName = 'Caguin'").getResultList();
			System.out.println("\nGetting Caguin:");
			displayStudents(students);
			
			// query students: lastName = 'Caguin' firstName = 'Arlene'
			students = session.createQuery("from Student s where " 
					+ "s.lastName = 'Caguin' OR s.firstName = 'Khaye'").getResultList();
			System.out.println("\nGetting Caguin / Khaye:");
			displayStudents(students);
			
			// query students ends with @gmai.com
			students = session.createQuery("from Student s where"
					+ " s.email LIKE '%gmai.com'").getResultList();
			System.out.println("\nUsing LIKE");
			displayStudents(students);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

}
