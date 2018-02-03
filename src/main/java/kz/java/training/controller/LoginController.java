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

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginManager loginManager;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPage(@ModelAttribute User user, @RequestParam String databaseError, RedirectAttributes rd) {
		if(databaseError.equals("error")) {
			rd.addFlashAttribute("databaseError", databaseError);
			return new ModelAndView("redirect:/");
		} else {
		    return new ModelAndView("login", "user", user);
		}
	}

	@RequestMapping(value = "/check-input-user-data", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody boolean setJsonUser(@Valid @RequestBody User user, BindingResult bindingResult) {
		boolean flag = loginManager.checkIfUserCanLogin(user, bindingResult);
		return flag;
	}
		
}
