package kz.java.training.service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.entity.MusicGenre;
import kz.java.training.entity.AddTicket;
import kz.java.training.entity.Ticket;

public interface TicketManager {
	
	String addTickets(AddTicket addTicket, MusicGenre musicGenre, Date dateOfTheEvent, BindingResult bindingResult, MultipartFile multipartFile, RedirectAttributes rd);
	
	ModelAndView findTickets(Ticket searchTicket, MusicGenre musicGenre);
	
	ModelAndView findTicket(int ticketId) throws ParseException;

	boolean isAcceptableNumberOfTickets(int numberOfTickets, int ticketId);

}
