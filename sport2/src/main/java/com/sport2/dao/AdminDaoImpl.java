package com.sport2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sport2.bean.Batch_Reg;
import com.sport2.bean.Ground_Reg;
import com.sport2.bean.Users;

@Repository
public class AdminDaoImpl implements AdminDaoI {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Users> userList() {
		Query sql = em.createQuery("select u from Users u");
		List<Users> user =  sql.getResultList();
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<Ground_Reg> groundList() {
		Query sql = em.createQuery("select g from Ground_Reg g");
		List<Ground_Reg> ground =  sql.getResultList();
		return ground;	
	}

	@SuppressWarnings("unchecked")
	public List<Batch_Reg> batchList() {
		Query sql = em.createQuery("select b from Batch_Reg b");
		List<Batch_Reg> batch =  sql.getResultList();
		return batch;
	}

	public Ground_Reg update_status(Ground_Reg gr_app) {

		System.out.println(gr_app);
		em.createNativeQuery("UPDATE GROUNDS SET `status`=? WHERE `id`=?")
	      .setParameter(1,gr_app.getStatus())
	      .setParameter(2,gr_app.getId())
	      .executeUpdate();
		return gr_app;
	}

	public Integer reject(Integer id) {
	
		System.out.println(id);
		
		Ground_Reg ground = em.find(Ground_Reg.class, id);
		
		em.remove(ground);
		
		return id;
	}

}
