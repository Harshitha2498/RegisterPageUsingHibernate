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
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;

	public void init() {
		userDao = new UserDAOImpl();
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User u = userDao.getUser(id);
		request.setAttribute("user", u);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		if (id!=null&& !id.isEmpty()) {
			User u = userDao.getUser(Integer.parseInt(id));
			user.setId(Integer.parseInt(id));
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setGender(gender);
			user.setEmail(email);
			user.setMobile(mobile);
			userDao.updateUser(user);
			List<User> userList = userDao.getAllActiveUsers();
			session.setAttribute("USERS", userList);
			response.sendRedirect("dashboard.jsp");
		} else {
			if (firstName != null && firstName.trim() != null) {
				user.setFirstName(firstName.trim());
			}
			if (lastName != null && lastName.trim() != null) {
				user.setLastName(lastName.trim());
			}
			if (gender != null) {
				user.setGender(gender);
			}
			if (email != null) {
				user.setEmail(email);
			}
			if (mobile != null) {
				user.setMobile(mobile);
			}
			userDao.saveUser(user);
			List<User> userList = userDao.getAllActiveUsers();
			session.setAttribute("USERS", userList);
			response.sendRedirect("dashboard.jsp");
		}
	}
}
