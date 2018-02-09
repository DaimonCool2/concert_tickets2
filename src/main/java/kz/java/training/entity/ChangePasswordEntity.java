package kz.java.training.entity;

import javax.validation.constraints.NotEmpty;

public class ChangePasswordEntity {
	
	private int userId;
	
	@NotEmpty(message = "������ ����")
	private String currentPassword;
	
	@NotEmpty(message = "������ ����")
	private String newPassword;
	
	@NotEmpty(message = "������ ����")
	private String confirmNewPassword;
	
	
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
