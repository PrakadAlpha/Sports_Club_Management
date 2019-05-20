package com.sport2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sport2.bean.Batch_Reg;
import com.sport2.bean.Ground_Reg;
import com.sport2.bean.Users;
import com.sport2.service.AdminServiceI;
import com.sport2.service.MainServiceI;
import com.sport2.service.UserServiceI;

@Controller
public class AdminController {

	@Autowired
	AdminServiceI service;
	
	@Autowired
	UserServiceI u_service;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/ad_portal")
	public String Ad_portal(Model model){
if(check_user()) {
			
	return "ad_portal";
			
		}
		model.addAttribute("err", "Please Login..!");
		
		return "welcome"; 

		
	}
	
	@RequestMapping("/usr_list")
	public String Ad_List(ModelMap model){
		if(check_user()) {
			
			List<Users> user = service.userList();
			model.put("user", user);
			
			return "user_list";					
				}
				model.addAttribute("err", "Please Login..!");
				
				return "welcome"; 
	
			}
	
	@RequestMapping("/usr_batches")
	public String Ad_Batches(ModelMap model){
		if(check_user()) {
			
			List<Batch_Reg> batch = service.batchList();
			System.out.println(batch);
			model.put("batch", batch);
			
			return "ad_batches";					
				}
				model.addAttribute("err", "Please Login..!");
				
				return "welcome"; 

				
			}
	
	@RequestMapping("/usr_grounds")
	public String Ad_Grounds(ModelMap model){
		if(check_user()) {
			
			List<Ground_Reg> ground = service.groundList();

			model.put("ground", ground);
			
			return "ad_grounds";					
				}
				model.addAttribute("err", "Please Login..!");
				
				return "welcome"; 

				
			}
	
	@RequestMapping(value="/approved/{id}")
	public String Ground_approved(@PathVariable Integer id){
		
		Ground_Reg gr_app = new Ground_Reg();
		
		gr_app.setId(id);
		gr_app.setStatus("APPROVED");
	
		service.update_status(gr_app);
		
		
		return "redirect:/usr_grounds";
	}
	
	@RequestMapping(value="/reject/{id}")
	public String Ground_reject(@PathVariable Integer id, ModelMap model){

		Ground_Reg gr_app = new Ground_Reg();
		
		gr_app.setId(id);
		gr_app.setStatus("REJECTED");
		
		service.reject(gr_app);
			
		return "redirect:/usr_grounds";
	}
	
public boolean check_user() {
		
		if(session.getAttribute("userid") != null) {
			
			Integer c_user = (Integer) session.getAttribute("userid");
			
			System.out.println("In function");

			System.out.println(c_user);
			
			Users user = u_service.getUserById(c_user);
			
			Integer c_role = user.getRole();
			
			if(c_role.equals(MainServiceI.ROLE_ADMIN)) {
				
				return true;
		
			}		
		}
		return false;
	}
	
}
