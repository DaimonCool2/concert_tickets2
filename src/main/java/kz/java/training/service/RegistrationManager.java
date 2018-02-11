package kz.java.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import kz.java.training.dao.impl.UserDaoImpl;
import kz.java.training.entity.User;

public interface RegistrationManager {
	
	void registrateUser(User user);
	
	boolean checkIfUserExist(String username);
	
	boolean checkIfUserWithThisEmailExist(String email);

}
