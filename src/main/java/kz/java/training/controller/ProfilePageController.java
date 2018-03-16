package kz.java.training.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.aspect.annotation.LoadAttribute;
import kz.java.training.aspect.annotation.ReturnDefaultPageIfIdNull;
import kz.java.training.entity.ChangePasswordEntity;
import kz.java.training.entity.PersonalInformation;
import kz.java.training.service.ProfileManager;

@Controller
@SessionAttributes("id")
@RequestMapping(value = "/profile")
public class ProfilePageController {

	@Autowired
	private ProfileManager profileManager;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ReturnDefaultPageIfIdNull
	public ModelAndView profile(ModelMap modelMap) {
		return new ModelAndView("profile");
	}

	@RequestMapping(value = "/information", method = RequestMethod.GET)
	@ReturnDefaultPageIfIdNull
	public ModelAndView userInformation(ModelMap modelMap, @ModelAttribute("repeatChangePasswordEntity") ChangePasswordEntity changePasswordEntity) {
		ModelAndView modelAndView = new ModelAndView("user-information");
		modelAndView.addObject("personalInformation", new PersonalInformation());
		modelAndView.addObject("changePasswordEntity", changePasswordEntity);
		return modelAndView;
	}

	@RequestMapping(value = "/update-information", method = RequestMethod.POST)
	public String updateInformation(@Valid @ModelAttribute PersonalInformation personalInformation, @ModelAttribute("id") int userId, RedirectAttributes rd) {
		return profileManager.updateProfileInformation(personalInformation, userId);
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public String changePassword(@Valid @ModelAttribute ChangePasswordEntity changePasswordEntity,
			BindingResult bindingResult, @ModelAttribute("id") int userId, RedirectAttributes rd) {
		return profileManager.changePassword(changePasswordEntity, userId, bindingResult, rd);
	}

	@RequestMapping(value = "/check-current-password", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public boolean checkIfUserExist(@RequestParam String currentPassword, @ModelAttribute("id") int userId) {
		return profileManager.isCurrentPasswordCorrect(currentPassword, userId);
	}

	@ModelAttribute("username")
	@LoadAttribute
	public String getUsername(ModelMap modelMap) {
		return profileManager.getUsernameFromDB((int) modelMap.get("id"));
	}
	
	@ModelAttribute("personalInformationForProfile")
	@LoadAttribute
	public PersonalInformation getPersonalInformation(ModelMap modelMap) {
		return profileManager.getPersonalInformationFromDB((int) modelMap.get("id"));
	}
	
}
