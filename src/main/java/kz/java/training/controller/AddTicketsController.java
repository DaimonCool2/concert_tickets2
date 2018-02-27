package kz.java.training.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.entity.AddTicket;
import kz.java.training.entity.MusicGenre;
import kz.java.training.entity.Ticket;
import kz.java.training.entity.User;
import kz.java.training.service.AddTicketManager;

@Controller
public class AddTicketsController {
	
	@Autowired
	private AddTicketManager addTicketManager;

	@RequestMapping(value = "/add-ticket", method = RequestMethod.GET)
	public ModelAndView addTicket(@ModelAttribute("repeatAddTicket") AddTicket addTicket) {
		return new ModelAndView("add-ticket", "addTicket", addTicket);
	}

	@RequestMapping(value = "/add-new-ticket", method = RequestMethod.POST)
	public String addNewTicket(@Valid @ModelAttribute AddTicket addTicket, BindingResult bindingResult, @RequestParam Date dateAndTimeOfTheEvent,
			@RequestParam String musGenre, @RequestParam("fileImage") MultipartFile multipartFile, RedirectAttributes rd)  {
		return addTicketManager.addTickets(addTicket, MusicGenre.getMusicGenreEnum(musGenre), dateAndTimeOfTheEvent, bindingResult, multipartFile, rd);
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
	
}
