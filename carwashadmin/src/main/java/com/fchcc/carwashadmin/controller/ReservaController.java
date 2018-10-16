package com.fchcc.carwashadmin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fchcc.carwashadmin.dao.ReservaDAO;
import com.fchcc.carwashadmin.model.Reserva;

@Controller
public class ReservaController {

	@Autowired
	private ReservaDAO reservaDAO;
	
	@RequestMapping(value="/enroll", method=RequestMethod.GET)
	public String newRegistrarion(ModelMap model) {
		Reserva reserva = new Reserva();
			model.addAttribute("reserva",reserva);
		return "enroll";
	}
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String saveRegistration(@Valid Reserva reserva, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			return "enroll";
		}
		
		reservaDAO.save(reserva);
		
		return "redirect:/viewreservas";
		
	}
	
	@RequestMapping("/viewreservas")
	public ModelAndView viewReservas() {
		List<Reserva> list = reservaDAO.getAllReservas();
		return new ModelAndView("viewreservas","list",list);
	}
	
	@RequestMapping(value="/editreserva/{id}")
	public String edit(@PathVariable int id, ModelMap model) {
		Reserva reserva = reservaDAO.getStudentById(id);
		model.addAttribute("reserva", reserva);
		return "editreserva";
	}
	
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("reserva") Reserva emp) {
		System.out.println("id is"+emp.getId());
		reservaDAO.update(emp);
		return new ModelAndView("redirect:/viewreservas");
	}
	
	
	@RequestMapping(value="/deletereserva/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		reservaDAO.delete(id);
		return new ModelAndView("redirect:/viewreservas");
	}
	
	
	
}
