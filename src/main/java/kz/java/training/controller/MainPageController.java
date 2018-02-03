package kz.java.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kz.java.training.entity.User;
import kz.java.training.exception.DatabaseAjaxQueryException;

@Controller
public class MainPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView mainPage(@ModelAttribute() User user, Model model) throws DatabaseAjaxQueryException {
		if(model.asMap().get("databaseError") != null) {
			throw new DatabaseAjaxQueryException();
		}
		return new ModelAndView("index", "user", user);
	}
}
