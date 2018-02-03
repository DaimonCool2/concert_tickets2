package kz.java.training.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kz.java.training.dao.impl.UserDao;
import kz.java.training.entity.RegistrationUser;
import kz.java.training.service.RegistrationManager;

@Service
public class RegistrationUserValidator implements Validator {

	private static final String USERNAME_PATTERN = "[a-zA-Z0-9_\\-]{3,}";
	private static final String PASSWORD_PATTERN = "[a-zA-Z0-9_\\-]{6,}";

	@Autowired
	@Qualifier("registrationManagerImpl")
	private RegistrationManager registrationManager;

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object regUser, Errors errors) {
		RegistrationUser user = (RegistrationUser) regUser;

		if (!user.getUsername().isEmpty() && !user.getPassword().isEmpty() && !user.getConfirmPassword().isEmpty()) {

			if (!user.getUsername().matches(USERNAME_PATTERN)) {
				errors.rejectValue("username", "username.pattern.error");
			}
			if (!user.getPassword().matches(PASSWORD_PATTERN)) {
				errors.rejectValue("password", "password.pattern.error");
			} else {
				if (!user.getPassword().equals(user.getConfirmPassword())) {
					errors.rejectValue("confirmPassword", "confirm.password.doesn't.match");
				}
			}
		}
		if (registrationManager.checkIfUserExist(user.getUsername())) {
			errors.rejectValue("username", "user.exists");
		}

	}

}
