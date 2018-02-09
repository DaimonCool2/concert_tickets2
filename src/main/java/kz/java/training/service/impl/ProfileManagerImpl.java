package kz.java.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.dao.PersonalINformationDao;
import kz.java.training.dao.UserDao;
import kz.java.training.dao.impl.PersonalInformationDaoImpl;
import kz.java.training.dao.impl.UserDaoImpl;
import kz.java.training.entity.ChangePasswordEntity;
import kz.java.training.entity.PersonalInformation;
import kz.java.training.entity.PersonalInformationWithUserId;
import kz.java.training.service.ProfileManager;
import kz.java.training.validator.ChangePasswordValidator;

@Service
public class ProfileManagerImpl implements ProfileManager {

	@Autowired
	private PersonalINformationDao personalInformationDao;
	
	@Autowired
	private ChangePasswordValidator changePasswordValidator;

	@Autowired
	private UserDao userDao;

	@Override
	public String updateProfileInformation(PersonalInformation personalInformation, int userId,
			BindingResult bindingResult, RedirectAttributes rd) {
		if (bindingResult.hasErrors()) {
			rd.addFlashAttribute("org.springframework.validation.BindingResult.personalInformation", bindingResult);
			rd.addFlashAttribute("repeatPersonalInformation", personalInformation);
		} else {
			if (userDao.ifUserHasPersonalInformationForeignKey(userId)) {
				PersonalInformationWithUserId piWithUserId = new PersonalInformationWithUserId(personalInformation, userId);
                personalInformationDao.updateEntity(piWithUserId);
			} else {
				int piId = personalInformationDao.insertPersonalInformationWithGeneratedKey(personalInformation);
				userDao.insertPersonalInformationForeignKey(userId, piId);
			}
		}
		return "redirect:/profile-information";
	}

	@Override
	public String changePassword(ChangePasswordEntity changePasswordEntity, int userId, BindingResult bindingResult,
			RedirectAttributes rd) {
		changePasswordEntity.setUserId(userId);
		changePasswordValidator.validate(changePasswordEntity, bindingResult);
		if (bindingResult.hasErrors()) {
			rd.addFlashAttribute("org.springframework.validation.BindingResult.changePasswordEntity", bindingResult);
			rd.addFlashAttribute("repeatChangePasswordEntity", changePasswordEntity);
		} else {
			userDao.changePassword(changePasswordEntity.getNewPassword(), userId);
		}
		return "redirect:/profile-information";
	}

	@Override
	public boolean isCurrentPasswordCorrect(String currentPassword, int userId) {
		return userDao.isCurrentPasswordIsCorrect(currentPassword, userId);
	}

}  
