package com.fchcc.carwashadmin.controller;


//import java.util.Date;
//import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fchcc.carwashadmin.dao.ReservaDaoImpl;
import com.fchcc.carwashadmin.model.Reserva;
@Controller
public class ReservaController {
	
	@Autowired
	ReservaDaoImpl reservadaoimpl;
	
	public void serResevadaoimpl(ReservaDaoImpl reservadaoimpl) {
		this.reservadaoimpl = reservadaoimpl;
	}
	
	
	@RequestMapping(value="/enroll", method=RequestMethod.GET)
	public String newRegistrarion(ModelMap model) {
		Reserva reserva = new Reserva();
			model.addAttribute("reserva",reserva);
		return "views/enroll";
	}
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String saveRegistration(@Valid Reserva reserva, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			System.out.println(result.getFieldError());
			
			
			return "views/enroll";
		}
		
		reservadaoimpl.save(reserva);
		
		return "redirect:/viewreserva";
		
	}
	
	@RequestMapping("/viewreserva")
	public ModelAndView viewReserva() {
		List<Reserva>list = reservadaoimpl.getAllReservas();
		return new ModelAndView("views/viewreserva","list",list);
	}
	
	@RequestMapping(value="/editreserva/{id}")
	public String edit(@PathVariable int id, ModelMap model) {
		Reserva reserva = reservadaoimpl.getStudentById(id);
		model.addAttribute("reserva", reserva);
		return "views/editreserva";
	}
	
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("reserva") Reserva rev, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			System.out.println(result.getFieldError());
		}
		System.out.println("id is"+rev.getId());
		reservadaoimpl.update(rev);
		return new ModelAndView("redirect:/viewreserva");
	}
	
	
	@RequestMapping(value="/deletereserva/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		reservadaoimpl.delete(id);
		return new ModelAndView("redirect:/viewreserva");
	}
	
	@RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
    public ModelAndView downloadExcel() {
		List<Reserva>list = reservadaoimpl.getAllReservas();
		return new ModelAndView("pdfView","list",list);
    }
	
	/*@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "Fecha", new CustomDateEditor(dateFormat, true));
	} 
	
	@InitBinder
	public void dataTimeBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "Hora", new CustomDateEditor(dateFormat, true));
	} */
	
}

