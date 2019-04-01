package com.sport2.dao;

import java.util.List;

import com.sport2.bean.Batch_Reg;
import com.sport2.bean.Ground_Reg;
import com.sport2.bean.Users;

public interface AdminDaoI {

	public List<Users> userList();

	public List<Ground_Reg> groundList();

	public List<Batch_Reg> batchList();
	
	public Ground_Reg update_status(Ground_Reg gr_app);

	public Integer reject(Integer id);

}
