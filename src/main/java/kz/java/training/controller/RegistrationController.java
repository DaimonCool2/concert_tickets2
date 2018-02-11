package kz.java.training.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.entity.RegistrationUser;
import kz.java.training.entity.User;
import kz.java.training.exceptionhandler.GlobalExceptionHandler;
import kz.java.training.service.RegistrationManager;
import kz.java.training.validator.RegistrationUserValidator;

@Controller
public class RegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private RegistrationUserValidator registrationUserValidator;

	@Autowired
	private RegistrationManager registrationManager;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(@ModelAttribute("repeatRegUser") RegistrationUser regUser) {
		return new ModelAndView("registration", "regUser", regUser);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute RegistrationUser regUser, BindingResult bindingResult,
			RedirectAttributes rd) {
		registrationUserValidator.validate(regUser, bindingResult);
		if (bindingResult.hasErrors()) {
			rd.addFlashAttribute("org.springframework.validation.BindingResult.regUser", bindingResult);
			rd.addFlashAttribute("repeatRegUser", regUser);
			return "redirect:/registration";
		} else {
			registrationManager.registrateUser(regUser);
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/check-if-user-exist", method = RequestMethod.POST, produces = {
			"text/html; charset=UTF-8" })
	@ResponseBody
	public String checkIfUserExist(@RequestParam String username) {
		String usernamePattern = "[a-zA-Z0-9_\\-]{3,}";
		if (username.matches(usernamePattern)) {
			if (registrationManager.checkIfUserExist(username)) {
				return "Пользователь с таким именем уже существует";
			} else {
				return "Можно создать";
			}
		} else {
			return "Некорректное имя пользователя";
		}
	}

	@RequestMapping(value = "/check-email-exist", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public boolean checkEmailExist(@RequestParam String email) {
		return registrationManager.checkIfUserWithThisEmailExist(email);
	}

}
