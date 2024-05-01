package com.registration.service;

import java.util.List;

import com.registration.dao.UserDAO;
import com.registration.model.User;

/**
 * @Author : Harshitha D
 * @Created: Apr 10, 2024
 * @File : RegisterForm.java
 * @Description : 
 */
public class UserService {
	private UserDAO userDao;
	public List<User> searchUser(User user){
		return userDao.searchUsers(user);
	}
}
