package kz.java.training.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.entity.MusicGenre;
import kz.java.training.entity.Ticket;
import kz.java.training.entity.User;
import kz.java.training.service.AddTicketManager;

@Controller
public class AddTicketsController {
	
	@Autowired
	private AddTicketManager addTicketManager;

	@RequestMapping(value = "/add-ticket", method = RequestMethod.GET)
	public ModelAndView addTicket(@ModelAttribute("repeatTicket") Ticket ticket) {
		return new ModelAndView("add-ticket", "ticket", ticket);
	}

	@RequestMapping(value = "/add-new-ticket", method = RequestMethod.POST)
	public String addNewTicket(@Valid @ModelAttribute Ticket ticket, BindingResult bindingResult, @RequestAttribute Calendar dateOfTheEvent,
			@RequestAttribute MusicGenre musicGenre, @RequestParam("fileImage") MultipartFile multipartFile, RedirectAttributes rd)  {
		return addTicketManager.addTickets(ticket, musicGenre, dateOfTheEvent, bindingResult, multipartFile, rd);
		//return new ModelAndView("add-ticket", "ticket", ticket);
	}
}
