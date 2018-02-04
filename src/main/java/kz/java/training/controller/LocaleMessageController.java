package kz.java.training.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LocaleMessageController {
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = "/get-message-empty-field", method = RequestMethod.GET, produces = {
			"text/html; charset=UTF-8" })
	@ResponseBody
	public String getMessageEmptyField() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("empty.field", new Object[0], locale);
	}

	@RequestMapping(value = "/get-message-password-pattern-password", method = RequestMethod.GET, produces = {
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
