package kz.java.training.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kz.java.training.entity.AddTicket;
import kz.java.training.entity.Ticket;

@Service
public class TicketValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		AddTicket addTicket = (AddTicket) target;
		if (addTicket.getMusicGenre() == null) {
			errors.rejectValue("musicGenre", "musiñ.genre.is.null");
		}

	}

}
