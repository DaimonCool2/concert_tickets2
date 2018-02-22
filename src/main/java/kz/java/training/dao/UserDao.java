package kz.java.training.dao;

import kz.java.training.entity.User;

public interface UserDao extends AbstractDao<User>{
	
	int selectUserId(String username);

	boolean isUserExist(String username);

	boolean isUserExist(User user);
	
	void insertPersonalInformationForeignKey(int userId, int personalInformationId);
	
	boolean ifUserHasPersonalInformationForeignKey(int userId);
	
	void changePassword(String newPassword, int userId);
	
	boolean isCurrentPasswordIsCorrect(String currentPassword, int userId);
	
	boolean isUserWithThisEmailExist(String email);
	
	String selectUsername(int userId);

}
