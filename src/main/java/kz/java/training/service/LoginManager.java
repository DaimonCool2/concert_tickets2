package kz.java.training.service;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.entity.User;

public interface LoginManager {
	
	String login(User user, BindingResult bindingResult, RedirectAttributes rd, ModelMap modelMap);
	
	boolean checkIfUserCanLogin(User user);

}
