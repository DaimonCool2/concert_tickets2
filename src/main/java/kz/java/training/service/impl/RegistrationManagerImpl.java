package kz.java.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kz.java.training.dao.UserDao;
import kz.java.training.dao.impl.UserDaoImpl;
import kz.java.training.entity.User;
import kz.java.training.service.RegistrationManager;

@Service
public class RegistrationManagerImpl implements RegistrationManager {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void registrateUser(User user) {
		userDao.insertEntity(user);
	}

	@Override
	public boolean checkIfUserExist(String username) {
		return userDao.isUserExist(username);
	}

	@Override
	public boolean checkIfUserWithThisEmailExist(String email) {
		return userDao.isUserWithThisEmailExist(email);
	}
      
}
