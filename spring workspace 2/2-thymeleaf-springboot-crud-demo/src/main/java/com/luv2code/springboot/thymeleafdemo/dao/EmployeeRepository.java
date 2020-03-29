package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	/*
	 * Method findAllByOrderByLastNameAsc will be parsed automatically, for more info
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
	 */

	// custom methods starts here
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
