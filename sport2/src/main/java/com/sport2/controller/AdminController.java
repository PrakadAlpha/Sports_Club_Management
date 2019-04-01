package com.sport2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sport2.bean.Batch_Reg;
import com.sport2.bean.Ground_Reg;
import com.sport2.bean.Users;
import com.sport2.service.AdminServiceI;

@Controller
public class AdminController {

	@Autowired
	AdminServiceI service;
	
	@RequestMapping("/ad_portal")
	public String Ad_portal(){
		return "ad_portal";
	}
	
	@RequestMapping("/usr_list")
	public String Ad_List(ModelMap model){
		
		List<Users> user = service.userList();
		model.put("user", user);
		
		return "user_list";
	}
	
	@RequestMapping("/usr_batches")
	public String Ad_Batches(ModelMap model){

		List<Batch_Reg> batch = service.batchList();
		model.put("batch", batch);
	
		return "ad_batches";
	}
	
	@RequestMapping("/usr_grounds")
	public String Ad_Grounds(ModelMap model){
		
		List<Ground_Reg> ground = service.groundList();

		model.put("ground", ground);
		
		return "ad_grounds";
	}
	
	
	@RequestMapping(value="/approved/{id}")
	public String Ground_approved(@PathVariable Integer id){
		
		Ground_Reg gr_app = new Ground_Reg();
		
		gr_app.setId(id);
		gr_app.setStatus("APPROVED");
	
		Ground_Reg gr = service.update_status(gr_app);
		
		System.out.println(gr);
		
		return "redirect:/usr_grounds";
	}
	
	@RequestMapping(value="/reject/{id}")
	public String Ground_reject(@PathVariable Integer id, ModelMap model){

		Integer rid = service.reject(id);
		
		model.put("id", rid);
		
		return "redirect:/usr_grounds";
	}
	
}
