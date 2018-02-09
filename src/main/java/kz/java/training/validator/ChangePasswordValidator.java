package kz.java.training.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kz.java.training.dao.UserDao;
import kz.java.training.entity.ChangePasswordEntity;
import kz.java.training.entity.User;

@Service
public class ChangePasswordValidator implements Validator {

	private static final String PASSWORD_PATTERN = "[a-zA-Z0-9_\\-]{6,}";

	@Autowired
	private UserDao userDao;

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object changePasswordEntity, Errors errors) {
		ChangePasswordEntity changePasswordEnt = (ChangePasswordEntity) changePasswordEntity;

		if (!changePasswordEnt.getCurrentPassword().isEmpty() && !changePasswordEnt.getNewPassword().isEmpty()
				&& !changePasswordEnt.getConfirmNewPassword().isEmpty()) {

			if (!changePasswordEnt.getNewPassword().matches(PASSWORD_PATTERN)) {
				errors.rejectValue("newPassword", "password.pattern.error");
			} else {
				if (!changePasswordEnt.getNewPassword().equals(changePasswordEnt.getConfirmNewPassword())) {
					errors.rejectValue("confirmNewPassword", "confirm.password.doesn't.match");
				} else {
					if (!userDao.isCurrentPasswordIsCorrect(changePasswordEnt.getCurrentPassword(),
							changePasswordEnt.getUserId())) {
						errors.rejectValue("currentPassword", "current.password.is.wrong");
					}
				}
			}
		}
	}

}
