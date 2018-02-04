package kz.java.training.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kz.java.training.dao.impl.UserDao;
import kz.java.training.entity.RegistrationUser;
import kz.java.training.entity.User;

@Service
public class LoginUserValidator implements Validator {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object user, Errors errors) {
		User loginUser = (User) user;

		if (!userDao.isUserExist(loginUser)) {
			errors.rejectValue("username", "incorrect.input.data");
		}
	}

}
