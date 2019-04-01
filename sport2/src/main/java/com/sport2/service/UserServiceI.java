package com.sport2.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.sport2.bean.Batch_Reg;
import com.sport2.bean.Ground_Reg;
import com.sport2.bean.Users;

public interface UserServiceI {

	public Users save(Users user);
	public void update(Users user);
	public Batch_Reg save_batch(Batch_Reg batch);
	public Ground_Reg save_ground(Ground_Reg ground);
	public List<Ground_Reg> req_status(Integer id);
}
