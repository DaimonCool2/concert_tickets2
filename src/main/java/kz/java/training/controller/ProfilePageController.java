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

import kz.java.training.entity.ChangePasswordEntity;
import kz.java.training.entity.PersonalInformation;
import kz.java.training.service.ProfileManager;

@Controller
@SessionAttributes("id")
public class ProfilePageController {

	@Autowired
	private ProfileManager profileManager;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(ModelMap modelMap) {
		if (modelMap.get("id") == null) {
			return "redirect:/";
		} else {
			return "profile";
		}
	}

	@RequestMapping(value = "/profile-information", method = RequestMethod.GET)
	public ModelAndView userInformation(
			@ModelAttribute("repeatPersonalInformation") PersonalInformation personalInformation,
			@ModelAttribute("repeatChangePasswordEntity") ChangePasswordEntity changePasswordEntity) {
		ModelAndView modelAndView = new ModelAndView("user-information");
		modelAndView.addObject("personalInformation", personalInformation);
		modelAndView.addObject("changePasswordEntity", changePasswordEntity);
		return modelAndView;
	}

	@RequestMapping(value = "/update-information", method = RequestMethod.POST)
	public String updateInformation(@Valid @ModelAttribute PersonalInformation personalInformation,
			BindingResult bindingResult, @ModelAttribute("id") int userId, RedirectAttributes rd) {
		return profileManager.updateProfileInformation(personalInformation, userId, bindingResult, rd);
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public String changePassword(@Valid @ModelAttribute ChangePasswordEntity changePasswordEntity,
			BindingResult bindingResult, @ModelAttribute("id") int userId, RedirectAttributes rd) {
		return profileManager.changePassword(changePasswordEntity, userId, bindingResult, rd);
	}

	@RequestMapping(value = "/check-current-password", method = RequestMethod.POST, produces = {
			"application/json" })
	@ResponseBody
	public boolean checkIfUserExist(@RequestParam String currentPassword, @ModelAttribute("id") int userId) {
		if (profileManager.isCurrentPasswordCorrect(currentPassword, userId)) {
			return true;
		} else {
			return false;
		}
	}
}
