package com.sport2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sport2.bean.Batch_Reg;
import com.sport2.bean.Ground_Reg;
import com.sport2.bean.Users;
import com.sport2.dao.AdminDaoI;

@Service
public class AdminServiceImpl implements AdminServiceI {
	
	@Autowired
	AdminDaoI dao;
	
	@Transactional
	public List<Users> userList() {		
		return dao.userList();
	}

	@Transactional
	public List<Ground_Reg> groundList() {
		return dao.groundList();
	}

	@Transactional
	public List<Batch_Reg> batchList() {
		return dao.batchList();
	}

	@Transactional
	public Ground_Reg update_status(Ground_Reg gr_app) {
		return dao.update_status(gr_app);
	}
	
	@Transactional
	public Integer reject(Integer id) {
		return dao.reject(id);
	}
}
