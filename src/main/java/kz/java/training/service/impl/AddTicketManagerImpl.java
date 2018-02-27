package kz.java.training.service.impl;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.DefaultManagedAwareThreadFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.sqlite.date.DateFormatUtils;

import kz.java.training.dao.TicketDao;
import kz.java.training.entity.AddTicket;
import kz.java.training.entity.MusicGenre;
import kz.java.training.entity.PersonalInformationWithUserId;
import kz.java.training.entity.Ticket;
import kz.java.training.service.AddTicketManager;
import kz.java.training.validator.TicketValidator;

@Service
public class AddTicketManagerImpl implements AddTicketManager {

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private TicketValidator addTicketValidator;

	@Override
	public String addTickets(Ticket ticket, MusicGenre musicGenre, Date dateAndTimeOfTheEvent,
			BindingResult bindingResult, MultipartFile multipartFile, RedirectAttributes rd) {
		String page;
		AddTicket addTicket = (AddTicket) ticket;
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
			page = "redirect:/add-ticket";
		} else {
			ticketDao.addTickets(addTicket);
			page = "redirect:/add-ticket";
		}
		return page;
	}

}
