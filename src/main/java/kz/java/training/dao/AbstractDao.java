package kz.java.training.dao;

import kz.java.training.entity.User;

public interface AbstractDao<T> {
	
	T findEntityById(int id);

	void deleteEntityById(int id);

	void insertEntity(T entity);
	
	boolean isUserExist(String username);
	
	boolean isUserExist(User user);
}
