package com.fchcc.carwashadmin.controller;



import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fchcc.carwashadmin.dao.UsersDAO;
import com.fchcc.carwashadmin.model.Users;

@Controller
public class LoginController {
	
	
	@Autowired
	private UsersDAO usersdao;
	
	@RequestMapping(value="/loginpage", method=RequestMethod.GET)
	public String login(ModelMap model) {
		
		
			Users users = new Users();
			model.addAttribute("users", users);
			return "loginpage";
			
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loggear(@Valid Users users,BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {
		
			if(result.hasErrors()) {
				System.out.println(result.getFieldError().getField());
				System.out.println(result.getObjectName());
				System.out.println(result.getFieldError().getCode());
				model.addAttribute("message", "ERROR");
				return "loginpage";
			}
			
			usersdao.getUser(users.getId(), users.getPassword());
			
		return "redirect:/viewreservas";
		
	}
		
}
