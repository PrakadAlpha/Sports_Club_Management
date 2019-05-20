package com.sport2.dao;

import java.util.List;

import com.sport2.bean.Batch_Reg;
import com.sport2.bean.Ground_Reg;
import com.sport2.bean.Users;

public interface UserDaoI {

	
	public Users save(Users user);
	public void update(Users user);
	public Batch_Reg save_batch(Batch_Reg batch);
	public Ground_Reg save_ground(Ground_Reg ground);
	public List<Ground_Reg> req_status(Integer id);
	public Users getUserById(Integer c_user);
	
	
}
