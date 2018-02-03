package kz.java.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kz.java.training.dao.impl.UserDao;
import kz.java.training.entity.User;
import kz.java.training.service.LoginManager;

@Service
public class LoginManagerImpl implements LoginManager {
	
	@Autowired
	private UserDao userDao;


	@Override
	public boolean checkIfUserCanLogin(User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return false;
		} else {
			return userDao.isUserExist(user);
		}
	}


}
