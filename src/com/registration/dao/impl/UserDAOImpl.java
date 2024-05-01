/**
 * 
 */
package com.registration.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.registration.dao.UserDAO;
import com.registration.model.User;
import com.registration.utils.HibernateUtil;

/**
 * @Author : Harshitha D
 * @Created: Apr 10, 2024
 * @File : UserDao.java
 * @Description : 
 */
public class UserDAOImpl implements UserDAO{

	@Override
	public List<User> searchUsers(User user) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Query query=session.createQuery("from User where isDeleted=0");
		return query.list();
	}

	@Override
	public User findById(int id) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		User u=session.find(User.class, id);

		return u;
	}
	public void saveUser(User user){
		//session open session
		//save the register from user
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction txn=session.beginTransaction();
		session.save(user);
		txn.commit();
		
		
	}
	public void updateUser(User user) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction txn=session.beginTransaction();
		 if (user != null) {
			 session.update(user);
            System.out.println("user is updated");
        }
		 txn.commit();
		
	}
	public void deleteUser(int id) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		User user=session.get(User.class,id);
		Transaction txn=session.beginTransaction();
		 if (user != null) {
			 user.setDeleted(true);
             session.update(user);
             System.out.println("user is deleted");
         }
		 txn.commit();
	}
	public User getUser(int id) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		 User users = session.get(User.class, id);
		return users;
	}

	@Override
	public List<User> getAllActiveUsers() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Query query=session.createQuery("from User where isDeleted=0");
		return query.list();
	}
}
