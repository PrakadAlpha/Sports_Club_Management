package com.sport2.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.sport2.bean.Users;

@Repository
public class MainDaoImpl implements MainDaoI {

	@PersistenceContext
	private EntityManager em;

	public Users login(String username, String password) {

		Query u = em.createQuery("select u FROM Users u WHERE u.username = :username AND u.password = :password");
		
		u.setParameter("username", username);
		u.setParameter("password", password);
	
	try{	
	 	Users user = (Users) u.getSingleResult();
	 	return user;
	}catch(NoResultException ex){
		return null;
	}
	}
}
