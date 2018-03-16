package kz.java.training.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.DefaultManagedAwareThreadFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.sqlite.date.DateFormatUtils;

import kz.java.training.dao.TicketDao;
import kz.java.training.entity.AddTicket;
import kz.java.training.entity.MusicGenre;
import kz.java.training.entity.PersonalInformationWithUserId;
import kz.java.training.entity.SearchTicket;
import kz.java.training.entity.Ticket;
import kz.java.training.service.TicketManager;
import kz.java.training.validator.TicketValidator;

@Service
public class TicketManagerImpl implements TicketManager {

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private TicketValidator addTicketValidator;

	@Override
	public String addTickets(AddTicket addTicket, MusicGenre musicGenre, Date dateAndTimeOfTheEvent,
			BindingResult bindingResult, MultipartFile multipartFile, RedirectAttributes rd) {
		try {
			if (dateAndTimeOfTheEvent == null) {
				bindingResult.rejectValue("dateOfTheEvent", "date.of.the.event.is.null");
			} else {
				Calendar dateOfTheEvent = Calendar.getInstance();
				dateOfTheEvent.setTime(dateAndTimeOfTheEvent);
				addTicket.setDateOfTheEvent(dateOfTheEvent);
				addTicket.setMusicGenre(musicGenre);
				addTicket.setImage(multipartFile.getBytes());
			}
			addTicketValidator.validate(addTicket, bindingResult);
		} catch (IOException e) {
			// loggining
			e.printStackTrace();
		}
		if (bindingResult.hasErrors()) {
			rd.addFlashAttribute("org.springframework.validation.BindingResult.addTicket", bindingResult);
			rd.addFlashAttribute("repeatAddTicket", addTicket);
		} else {
			ticketDao.addTickets(addTicket);
		}
		return "redirect:/add-ticket";
	}

	@Override
	public ModelAndView findTickets(Ticket searchTicket, MusicGenre musicGenre) {
		ModelAndView modelAndView = new ModelAndView("search-page");
		searchTicket.setMusicGenre(musicGenre);
		
		List<SearchTicket> listOfTickets = ticketDao.selectTickets(searchTicket);		
		modelAndView.addObject("searchTicket", new Ticket());
		modelAndView.addObject("listOfTickets", listOfTickets);
		return modelAndView;
	}

	@Override
	public ModelAndView findTicket(int ticketId) throws ParseException {
		ModelAndView modelAndView = new ModelAndView("ticket");
		modelAndView.addObject("searchTicket", new Ticket());
		SearchTicket ticket = (SearchTicket) ticketDao.findEntityById(ticketId);
		
		Calendar currentTime = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = sdf.parse(ticket.getDateOfTheEventForPage());
		Calendar dateOfTheEvent = Calendar.getInstance();
		dateOfTheEvent.setTime(date);
		
		modelAndView.addObject("isValidDate", dateOfTheEvent.compareTo(currentTime) > 0);
		modelAndView.addObject("ticket", ticket);
		return modelAndView;
	}

	@Override
	public boolean isAcceptableNumberOfTickets(int numberOfTickets, int ticketId) {
		return ticketDao.isAcceptableNumberOfTickets(numberOfTickets, ticketId);
	}
	

}
