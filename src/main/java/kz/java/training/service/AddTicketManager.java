package kz.java.training.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.entity.MusicGenre;
import kz.java.training.entity.Ticket;

public interface AddTicketManager {
	
	public String addTickets(Ticket ticket, MusicGenre musicGenre, Date dateOfTheEvent, BindingResult bindingResult, MultipartFile multipartFile, RedirectAttributes rd);

}
