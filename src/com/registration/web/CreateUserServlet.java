package com.registration.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registration.dao.UserDAO;
import com.registration.dao.impl.UserDAOImpl;
import com.registration.model.User;

/**
 * Servlet implementation class CreateUser
 */
//@WebServlet("/CreateUser")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDao;

	public void init() {
		userDao = new UserDAOImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=new User();
		HttpSession session = request.getSession();
		
		String firstName = request.getParameter("firstName");
		if (firstName != null && firstName.trim() != null) {
			user.setFirstName(firstName.trim());
		}
		String lastName = request.getParameter("lastName");
		if (lastName != null && lastName.trim() != null) {
			user.setLastName(lastName.trim());
		}
		String gender = request.getParameter("gender");
		if (gender != null) {
			user.setGender(gender);
		}
		String email = request.getParameter("email");
		if (email != null ) {
			user.setEmail(email);
		}
		String mobile = request.getParameter("mobile");
		if (mobile != null ) {
			user.setMobile(mobile);
		}
		userDao.saveUser(user);
		List<User> userList=userDao.getAllActiveUsers(); 
		session.setAttribute("USERS", userList);
		response.sendRedirect("dashboard.jsp");
	}

}
