package com.sport2.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.sport2.bean.Batch_Reg;
import com.sport2.bean.Ground_Reg;
import com.sport2.bean.Users;

@Repository
public class UserDaoImpl implements UserDaoI {

	@PersistenceContext
	private EntityManager em;
	
	public Users save(Users user) {
		em.persist(user);
		return user;
	}

	public void update(Users user) {
		
	}

	public Batch_Reg save_batch(Batch_Reg batch) {
	
		em.createNativeQuery("INSERT INTO BATCHES (`sport_name`, `sport_time`, `desc`, `user_userid`) VALUES (?,?,?,?)")
	      .setParameter(1, batch.getSport_name())
	      .setParameter(2, batch.getSport_time())
	      .setParameter(3, batch.getDesc())
	      .setParameter(4, batch.getUser().getId())
	      .executeUpdate();
		return batch;
	}

	public Ground_Reg save_ground(Ground_Reg ground) {
		em.createNativeQuery("INSERT INTO GROUNDS (`event`, `date`, `desc`, `user_userid`) VALUES (?,?,?,?)")
	      .setParameter(1, ground.getEvent())
	      .setParameter(2, ground.getDate())
	      .setParameter(3, ground.getDesc())
	      .setParameter(4, ground.getUser().getId())
	      .executeUpdate();
		return ground;		
	}

	@SuppressWarnings("unchecked")
	public List<Ground_Reg> req_status(Integer id) {
		Query sql = em.createQuery("select g from Ground_Reg g where user_userid = :id");
		sql.setParameter("id", id);
		List<Ground_Reg> ground =  sql.getResultList();
		return ground;
	}

	public Users getUserById(Integer c_user) {
		
		return em.find(Users.class, c_user);

	}

	public Object findByDate(Date value) {

		Query sql = em.createQuery("select g from Ground_Reg g where date = :value");
		sql.setParameter("value", value);
		
		return sql;

	}

}
