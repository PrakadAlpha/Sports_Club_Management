package com.sport2.controller;
import java.text.ParseException;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.sport2.bean.Batch_Reg;
import com.sport2.bean.Ground_Reg;
import com.sport2.bean.Users;
import com.sport2.service.UserServiceI;

@Controller
public class UserController {

	@Autowired
	UserServiceI service;
	
	@RequestMapping("/usr_register")
	public String Usr_reg(Model model){
		model.addAttribute("users",new Users());
			return "user_reg";
	}

	@RequestMapping("/usr_batch")
	public String Usr_Batch(Model model){
		model.addAttribute("batch",new Batch_Reg());
		return "batch_reg";
	}
	@RequestMapping("/usr_ground")
	public String Usr_Ground(Model model){
		model.addAttribute("ground", new Ground_Reg());
		return "ground_reg";
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
		
		model.put("id", reg_user.getId());
		
		return "thankyou";
	}

	@RequestMapping(value = "/ground", method = RequestMethod.POST)
	public String User_Ground(@Valid @ModelAttribute("ground") Ground_Reg ground,BindingResult result, ModelMap model) throws ParseException{

		
		if(result.hasErrors()){
			return "ground_reg";
		}
		
		
		Ground_Reg g = new Ground_Reg();
		
		g.setEvent(ground.getEvent());
		g.setDate(ground.getDate());
		g.setDesc(ground.getDesc());

		System.out.println(g);

		
		Ground_Reg gr = service.save_ground(g);
		
		model.put("id", gr.getId());
		
		return "thankyou";
	}

	@RequestMapping(value = "/batch", method = RequestMethod.POST)
	public String User_Batch(@Valid @ModelAttribute("batch") Batch_Reg batch,BindingResult result, ModelMap model){
		
		
		if(result.hasErrors()){
			return "batch_reg";
		}	
		
		Batch_Reg b = new Batch_Reg();
		
		b.setSport_name(batch.getSport_name());
		b.setSport_time(batch.getSport_time());
		b.setDesc(batch.getDesc());
		
		System.out.println(b);
		
		Batch_Reg ba = service.save_batch(b);
		
		System.out.println(ba);
		
		model.put("id", ba.getId());
		
		return "thankyou";
	}

	
	@RequestMapping("/status/{id}")
	public String req_status(ModelMap model, @PathVariable Integer id){
		
		System.out.println(id);
				
		List<Ground_Reg> list = service.req_status(id);

		model.put("ground", list);
		
		return "req_status";
	}
	
	
}
