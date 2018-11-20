package com.fchcc.carwashadmin.controller;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
	
	 @RequestMapping(value="/login", method = RequestMethod.GET)
	 public ModelAndView login(@RequestParam(value="error", required = false) String error){
	  
	  ModelAndView model = new ModelAndView();
	  
	  if(error!=null) {
	   model.addObject("error", "Usuario o Contraseña incorrectos");
	  }
	  model.setViewName("views/loginpage");
	   return model;
	 }
	 
	 @RequestMapping(value={"/"}, method = RequestMethod.GET)
	 public ModelAndView reserva(){
	  
		 return new ModelAndView(new RedirectView("/viewreserva"));
	 }
}
