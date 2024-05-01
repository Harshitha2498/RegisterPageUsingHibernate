package com.registration.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.registration.model.User;

/**
 * @Author : Harshitha.D
 * @Created: Apr 10, 2024
 * @File : HibernateUtil.java
 * @Description : 
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null) {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(User.class);
			sessionFactory=configuration.buildSessionFactory();
			System.out.println("created");
		}
		return sessionFactory;
	}
}
