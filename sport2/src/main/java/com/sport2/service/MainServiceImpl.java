package com.sport2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport2.bean.Users;
import com.sport2.dao.MainDaoI;

@Service
public class MainServiceImpl implements MainServiceI {

	@Autowired
	MainDaoI dao;

	public Users login(String username, String password) {
		return dao.login(username, password);
	}
	
//	@Transactional

}
