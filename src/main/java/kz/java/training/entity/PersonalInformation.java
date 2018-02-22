package kz.java.training.entity;

import javax.validation.constraints.NotEmpty;

public class PersonalInformation {

	private String firstName;

	private String lastName;

	public PersonalInformation() {}

	public PersonalInformation(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
