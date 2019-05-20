package com.sport2.controller;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sport2.bean.Batch_Reg;
import com.sport2.bean.Ground_Reg;
import com.sport2.bean.Users;
import com.sport2.service.MainServiceI;
import com.sport2.service.UserServiceI;

@Controller
public class UserController {

	@Autowired
	UserServiceI service;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/usr_register")
	public String Usr_reg(Model model){
		model.addAttribute("users",new Users());
			return "user_reg";
	}

	@RequestMapping("/usr_batch")
	public String Usr_Batch(Model model){
		
		model.addAttribute("batch",new Batch_Reg());
				
		if(check_user()) {
			
			return "batch_reg";
			
		}
		model.addAttribute("err", "Please Login..!");
		
		return "welcome"; 
	}
	@RequestMapping("/usr_ground")
	public String Usr_Ground(Model model){
		model.addAttribute("ground", new Ground_Reg());
		
		if(check_user()) {
			
	return "ground_reg";
			
		}
		model.addAttribute("err", "Please Login..!");
		
		return "welcome"; 
		
		
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String User_Register(@Valid @ModelAttribute("users") Users users,BindingResult result, ModelMap model){
		
		if(result.hasErrors()){
			return "user_reg";
		}
		
		
		Users user = new Users();
	
		System.out.println(users);
		
		user.setFullname(users.getFullname());
		user.setMobile(users.getMobile());
		user.setEmail(users.getEmail());
		user.setAddress(users.getAddress());
		user.setUsername(users.getUsername());
		user.setPassword(users.getPassword());

		System.out.println(user);
		
		Users reg_user = service.save(user);
		
		model.put("id", reg_user.getFullname());
		
		return "thankyou";
	}

	@RequestMapping(value = "/ground_reg", method = RequestMethod.POST)
	public String User_Ground(@Valid @ModelAttribute("ground") Ground_Reg ground, BindingResult result, ModelMap model, HttpSession session) throws ParseException{

		
		if(result.hasErrors()){
			return "ground_reg";
		}
		
		Integer c_user = (Integer) session.getAttribute("userid");
		
		System.out.println("In function");
		System.out.println(ground);
		
		Ground_Reg g = new Ground_Reg();
		Users user = service.getUserById(c_user);
		
		g.setEvent(ground.getEvent());
		g.setDate(ground.getDate());
		g.setDesc(ground.getDesc());
		g.setUser(user);
		
		System.out.println(g);		
				
		service.save_ground(g);
	
		
		return "g_thankyou";
	}

	@RequestMapping(value = "/batch", method = RequestMethod.POST)
	public String User_Batch(@Valid @ModelAttribute("batch") Batch_Reg batch,BindingResult result, ModelMap model, HttpSession session){
		
		
		if(result.hasErrors()){
			return "batch_reg";
		}	
		
		Integer c_user = (Integer) session.getAttribute("userid");

		
		Batch_Reg b = new Batch_Reg();
		Users user = service.getUserById(c_user);
		
		b.setSport_name(batch.getSport_name());
		b.setSport_time(batch.getSport_time());
		b.setDesc(batch.getDesc());
		b.setUser(user);
				
		service.save_batch(b);
						
		return "b_thankyou";
	}

	
	@RequestMapping("/status")
	public String req_status(ModelMap model, HttpSession session){
						
		Integer c_user = (Integer) session.getAttribute("userid");
		
		List<Ground_Reg> list = service.req_status(c_user);

		System.out.println();
		
		model.put("ground", list);
		
		return "req_status";
	}
	
	public boolean check_user() {
		
		if(session.getAttribute("userid") != null) {
			
			Integer c_user = (Integer) session.getAttribute("userid");
			
			System.out.println("In function");

			System.out.println(c_user);
			
			Users user = service.getUserById(c_user);
			
			Integer c_role = user.getRole();
			
			if(c_role.equals(MainServiceI.ROLE_USER)) {
				
				return true;
		
			}		
		}
		return false;
	}
}
