package kz.java.training.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.entity.AddTicket;
import kz.java.training.entity.MusicGenre;
import kz.java.training.entity.Ticket;
import kz.java.training.entity.User;
import kz.java.training.service.TicketManager;

@Controller
@SessionAttributes("id")
public class TicketController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TicketManager ticketManager;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchPage(@ModelAttribute("repeatSearchTicket") Ticket searchTicket) {
		return new ModelAndView("search-page", "searchTicket", searchTicket);
	}
	
	@RequestMapping(value = "/search/{ticketId}", method = RequestMethod.GET)
	public ModelAndView searchPage(@ModelAttribute("repeatSearchTicket") Ticket searchTicket, @PathVariable int ticketId, @RequestParam(required=false) String lang) throws ParseException {
		return ticketManager.findTicket(ticketId);
	}

	@RequestMapping(value = "/find-tickets", method = RequestMethod.GET)
	public ModelAndView findTickets(@ModelAttribute Ticket searchTicket, @RequestParam(required=false) String musGenre) {
		Locale locale = LocaleContextHolder.getLocale();
		MusicGenre musicGenre = MusicGenre.getMusicGenreEnumByDifferentLanguageValue(musGenre, messageSource, locale);
		return ticketManager.findTickets(searchTicket, musicGenre);
	}

	@RequestMapping(value = "/add-ticket", method = RequestMethod.GET)
	public ModelAndView addTicket(@ModelAttribute("repeatAddTicket") AddTicket addTicket) {
		return new ModelAndView("add-ticket", "addTicket", addTicket);
	}

	@RequestMapping(value = "/add-new-ticket", method = RequestMethod.POST)
	public String addNewTicket(@Valid @ModelAttribute AddTicket addTicket, BindingResult bindingResult, @RequestParam Date dateAndTimeOfTheEvent,
			@RequestParam String musGenre, @RequestParam("fileImage") MultipartFile multipartFile, RedirectAttributes rd)  {
		return ticketManager.addTickets(addTicket, MusicGenre.getMusicGenreEnum(musGenre), dateAndTimeOfTheEvent, bindingResult, multipartFile, rd);
	}
	
	@RequestMapping(value = "/buy-ticket", method = RequestMethod.POST)
	public String buyTicket(@RequestParam int numberOfTickets, RedirectAttributes rd)  {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/check-acceptable-number-of-tickets", method = RequestMethod.GET, produces = {"application/json"})
	@ResponseBody
	public boolean checkAcceptableNumberOftickets(@RequestParam int numberOfTickets, @RequestParam int ticketId) {
		return ticketManager.isAcceptableNumberOfTickets(numberOfTickets, ticketId);
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
	
}
