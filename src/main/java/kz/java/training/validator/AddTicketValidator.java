package kz.java.training.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kz.java.training.entity.Ticket;

@Service
public class AddTicketValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Ticket ticket = (Ticket) target;
		if (ticket.getMusicGenre() == null) {
			errors.rejectValue("musicGenreIsNull", "musin.genre.is.null");
		}
		if (ticket.getDateOfTheEvent() == null) {
			errors.rejectValue("dateOfTheEventIsNull", "date.of.the.event.is.null");
		}
	}

}
