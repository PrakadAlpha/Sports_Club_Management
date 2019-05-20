package com.sport2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sport2.bean.Batch_Reg;
import com.sport2.bean.Ground_Reg;
import com.sport2.bean.Users;
import com.sport2.dao.UserDaoI;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	UserDaoI dao;
	
	@Transactional
	public Users save(Users user) {
		return dao.save(user);
	}

	public void update(Users user) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public Batch_Reg save_batch(Batch_Reg batch) {
		return dao.save_batch(batch);
	}
	@Transactional
	public Ground_Reg save_ground(Ground_Reg ground) {
		return dao.save_ground(ground);
	}

	public List<Ground_Reg> req_status(Integer id) {
	
		return dao.req_status(id);
	}

	public Users getUserById(Integer c_user) {
		
		return dao.getUserById(c_user);
	}

}
