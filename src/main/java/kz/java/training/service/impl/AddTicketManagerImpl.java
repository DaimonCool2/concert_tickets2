package kz.java.training.service.impl;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.dao.TicketDao;
import kz.java.training.entity.MusicGenre;
import kz.java.training.entity.PersonalInformationWithUserId;
import kz.java.training.entity.Ticket;
import kz.java.training.service.AddTicketManager;
import kz.java.training.validator.AddTicketValidator;

@Service
public class AddTicketManagerImpl implements AddTicketManager {

	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private AddTicketValidator addTicketValidator;

	@Override
	public String addTickets(Ticket ticket, MusicGenre musicGenre, Calendar dateOfTheEvent, BindingResult bindingResult,
			MultipartFile multipartFile, RedirectAttributes rd) {
		String page = "error";
		try {
			ticket.setDateOfTheEvent(dateOfTheEvent);
			ticket.setMusicGenre(musicGenre);
			ticket.setImage(multipartFile.getBytes());
			addTicketValidator.validate(ticket, bindingResult);
		} catch (IOException e) {
			//loggining
			e.printStackTrace();
		}
		if (bindingResult.hasErrors()) {
			rd.addFlashAttribute("org.springframework.validation.BindingResult.ticket", bindingResult);
			rd.addFlashAttribute("repeatTicket", ticket);
			page = "redirect:/add-ticket";
		} else {
			ticketDao.addTickets(ticket);
			page = "redirect:/add-ticket";

		}
		return page;
	}

}
