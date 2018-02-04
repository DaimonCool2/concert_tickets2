package kz.java.training.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.entity.User;
import kz.java.training.service.LoginManager;
import kz.java.training.service.RegistrationManager;
import kz.java.training.validator.LoginUserValidator;
import kz.java.training.validator.RegistrationUserValidator;

@Controller
@SessionAttributes("id")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginManager loginManager;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(@Valid @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes rd, ModelMap modelMap) {
		return loginManager.login(user, bindingResult, rd, modelMap);
	}

	@RequestMapping(value = "/check-input-user-data", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody boolean setJsonUser(@RequestBody User user) {
		boolean flag = loginManager.checkIfUserCanLogin(user);
		return flag;
	}

}
