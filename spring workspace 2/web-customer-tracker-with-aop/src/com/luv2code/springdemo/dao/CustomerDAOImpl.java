package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

// double check
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// need to inject session factory from cfg file
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query, sort by last name
		Query<Customer> query = 
				currentSession.createQuery("from Customer order by lastName",
						Customer.class);
		
		// execute query and get result list
		List<Customer> customers = query.getResultList();
		
		// returns results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save / update the customer 
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = currentSession.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> queries = null;
		
		if (name != null) {
			queries = 
					currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", 
					Customer.class);
			
			queries.setParameter("theName", "%" + name.toLowerCase() + "%");


		} else {
			queries = 
					currentSession.createQuery("from Customer order by firstName", Customer.class);
		}
		
		List<Customer> customers = queries.getResultList();
		return customers;
	}
}
