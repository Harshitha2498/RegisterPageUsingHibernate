package com.registration.dao;

import java.util.List;

import com.registration.model.User;

/**
 * @Author : Harshitha D
 * @Created: Apr 10, 2024
 * @File : UserDao.java
 * @Description : 
 */
public interface UserDAO {
	public List<User> searchUsers(User user);

	public User findById(int id);
	public void saveUser(User user);

	public void updateUser(User user);
	public void deleteUser(int id);
	public User getUser(int id);

	public List<User> getAllActiveUsers();
}
