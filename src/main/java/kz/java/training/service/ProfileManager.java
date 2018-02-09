package kz.java.training.service;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.entity.ChangePasswordEntity;
import kz.java.training.entity.PersonalInformation;

public interface ProfileManager {
	
	String updateProfileInformation(PersonalInformation personalInformation, int userId, BindingResult bindingResult, RedirectAttributes rd);
	
	String changePassword(ChangePasswordEntity changePasswordEntity, int userId, BindingResult bindingResult, RedirectAttributes rd);

	boolean isCurrentPasswordCorrect(String password, int userId);
}
