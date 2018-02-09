package kz.java.training.entity;

public class PersonalInformationWithUserId extends PersonalInformation {

	private int userId;
	
	public PersonalInformationWithUserId(PersonalInformation personalInformation, int userId) {
		super(personalInformation.getFirstName(), personalInformation.getLastName());
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
