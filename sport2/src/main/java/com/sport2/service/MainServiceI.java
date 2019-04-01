package com.sport2.service;

import com.sport2.bean.Users;

public interface MainServiceI {

	public static final Integer ROLE_ADMIN=1;
	public static final Integer ROLE_USER=2;
	
	public Users login(String username, String password);
	
}
