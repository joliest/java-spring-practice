package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	// define field for EntityManager and setup constructor injection
	// any type of injection will work
	
	private EntityManager entityManager;
	
	// entity manager is already created by spring
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query - Native Hibernate API
		Query<Employee> query = 
				currentSession.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees = query.getResultList();
		
		
		//return result
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class,  id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		
		// if id is 0 it doesn't insert
		session.saveOrUpdate(employee);	
	}

	@Override
	public void deleteById(int employeeId) {
		Session session = entityManager.unwrap(Session.class);
		
		Query query =
				session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", employeeId);
		query.executeUpdate();
	}

}
