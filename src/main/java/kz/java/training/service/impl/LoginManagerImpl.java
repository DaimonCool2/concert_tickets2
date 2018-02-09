package kz.java.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.dao.UserDao;
import kz.java.training.dao.impl.UserDaoImpl;
import kz.java.training.entity.User;
import kz.java.training.service.LoginManager;
import kz.java.training.validator.LoginUserValidator;

@Service
public class LoginManagerImpl implements LoginManager {

	@Autowired
	private LoginUserValidator loginUserValidator;

	@Autowired
	private UserDao userDao;

	@Override
	public String login(User user, BindingResult bindingResult, RedirectAttributes rd, ModelMap modelMap) {
		String page;
		loginUserValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			rd.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
			rd.addFlashAttribute("repeatLoginUser", user);
			page = "redirect:/";
		} else {
			modelMap.addAttribute("id", userDao.selectUserId(user.getUsername()));
			page = "redirect:/profile";
		}
		return page;
	}

	@Override
	public boolean checkIfUserCanLogin(User user) {
		return userDao.isUserExist(user);
	}

}
