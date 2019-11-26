package com.luv2code.jdbc;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&severTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = (Connection) DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection Succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
