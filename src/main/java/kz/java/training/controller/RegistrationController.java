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
	private RegistrationUserValidator confirmPasswordValidator;

	@Autowired
	private RegistrationManager registrationManager;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(@ModelAttribute("repeatRegUser") RegistrationUser regUser) {
		return new ModelAndView("registration", "regUser", regUser);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute RegistrationUser regUser, BindingResult bindingResult,
			RedirectAttributes rd) {
		confirmPasswordValidator.validate(regUser, bindingResult);
		if (bindingResult.hasErrors()) {
			rd.addFlashAttribute("org.springframework.validation.BindingResult.regUser", bindingResult);
			rd.addFlashAttribute("repeatRegUser", regUser);
			return "redirect:/registration";
		} else {
			registrationManager.registrateUser(regUser);
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/check-if-user-exist", method = RequestMethod.GET, produces = {
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

	@RequestMapping(value = "/get-message-empty-field", method = RequestMethod.GET, produces = {
			"text/html; charset=UTF-8" })
	@ResponseBody
	public String getMessageEmptyField() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("empty.field", new Object[0], locale);
	}

	@RequestMapping(value = "/get-message-incorrect-password", method = RequestMethod.GET, produces = {
			"text/html; charset=UTF-8" })
	@ResponseBody
	public String getMessageIncorrectPassword() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("password.pattern.error", new Object[0], locale);
	}

	@RequestMapping(value = "/get-message-confirm-password-pattern-error", method = RequestMethod.GET, produces = {
			"text/html; charset=UTF-8" })
	@ResponseBody
	public String getMessageConfirmPasswordPatternError() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("confirm.password.doesn't.match", new Object[0], locale);
	}

	@RequestMapping(value = "/get-message-username-pattern-error", method = RequestMethod.GET, produces = {
			"text/html; charset=UTF-8" })
	@ResponseBody
	public String getMessageUsernamePatternError() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("username.pattern.error", new Object[0], locale);
	}

	@RequestMapping(value = "/get-message-incorrect-input-data", method = RequestMethod.GET, produces = {
			"text/html; charset=UTF-8" })
	@ResponseBody
	public String getIncorrectInputData() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("incorrect.input.data", new Object[0], locale);
	}

}
