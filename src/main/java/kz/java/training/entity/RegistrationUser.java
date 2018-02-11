package kz.java.training.entity;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;

import kz.java.training.validation.sequence.First;
import kz.java.training.validation.sequence.Second;

public class RegistrationUser extends User {
	
	@NotEmpty(message = "Пустое поле")
	private String email;
	
	@NotEmpty(message = "Пустое поле")
	private String confirmPassword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
