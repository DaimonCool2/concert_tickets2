package kz.java.training.service;

import org.springframework.validation.BindingResult;

import kz.java.training.entity.User;

public interface LoginManager {
	
	boolean checkIfUserCanLogin(User user, BindingResult bindingResult);

}
