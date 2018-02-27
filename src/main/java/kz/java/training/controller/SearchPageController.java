package kz.java.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kz.java.training.entity.AddTicket;
import kz.java.training.entity.Ticket;

@Controller
public class SearchPageController {
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView addTicket(@ModelAttribute("repeatAddTicket") Ticket searchTicket) {
		return new ModelAndView("search-page", "searchTicket", searchTicket);
	}

}
