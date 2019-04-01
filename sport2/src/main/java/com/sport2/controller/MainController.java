package com.sport2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sport2.bean.Users;
import com.sport2.service.MainServiceI;

@Controller
public class MainController {

	@Autowired
	MainServiceI service;
	
	@RequestMapping("/")
	public String Hello(){
		return "welcome";
	}
	
	@RequestMapping("/home")
	public String Home(){
		return "welcome";
	}
	
	@RequestMapping("/usr_home")
	public String User_home(){
		return "wel_user";
	}
	
	

	@RequestMapping("/usr_login")
	public String user_login(@RequestParam String username, @RequestParam String password, ModelMap model, HttpSession session){
		
		Users LoggedInUser = service.login(username, password);
		
	
		if(LoggedInUser == null){
			model.addAttribute("err", "Login Failed, Enter Valid Credentials");
			return "welcome";
		}
		else{
			
			if(LoggedInUser.getRole().equals(MainServiceI.ROLE_ADMIN)){
				addUserInSession(LoggedInUser, session);
				return "redirect:ad_portal";
			}
			else if(LoggedInUser.getRole().equals(MainServiceI.ROLE_USER)){
				addUserInSession(LoggedInUser, session);
				return "wel_user";
				
			}
		}
	
		return "wel_user";
	
	}
	
	
	@RequestMapping("/logout")
	public String User_Logout(HttpSession session, ModelMap model){
		session.invalidate();
		model.addAttribute("logout","Logged Out Sucessfully..!!");
		return "welcome";
	}
	
	public void addUserInSession(Users u, HttpSession session){
		session.setAttribute("user", u);
		session.setAttribute("userid", u.getId());
		session.setAttribute("role", u.getRole());
	}
	
}
