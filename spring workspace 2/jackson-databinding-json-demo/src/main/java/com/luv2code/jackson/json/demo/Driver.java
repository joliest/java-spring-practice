package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to JAVA POJO
			// data/sample-lite.json
			Student student =
					mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print first and lastname
			System.out.println("First name = " + student.getFirstName());
			System.out.println("Last name = " + student.getLastName());
			

			System.out.println("Address = " + student.getAddress().getCity());
			System.out.println("Languages = " + student.getLanguages()[0]);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
