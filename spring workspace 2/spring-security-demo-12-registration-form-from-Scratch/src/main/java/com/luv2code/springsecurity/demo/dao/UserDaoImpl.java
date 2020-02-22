package com.luv2code.springsecurity.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String userName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve / read from database using username
		Query<User> query = currentSession
				.createQuery("from User where userName=:uName", User.class);
		query.setParameter("uName", userName);
		User user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}
		
		return user;
	}

	@Override
	public void save(User user) {
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create user
		currentSession.saveOrUpdate(user);

	}

}
