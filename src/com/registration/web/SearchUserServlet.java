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
 * Servlet implementation class SearchUserServlet
 */
//@WebServlet("/searchUser")
public class SearchUserServlet extends HttpServlet {
	private UserDAO userDao;
	
	private static final long serialVersionUID = 1L;
       
    public void init() {
    	userDao = new UserDAOImpl();
    }

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserServlet() {
        super();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		HttpSession session = request.getSession();
		String firstName=request.getParameter("firstName");
		if(firstName!=null && firstName.trim()!=null) {
			user.setFirstName(firstName.trim());
		}
		List<User> userList=userDao.searchUsers(user);
		System.out.println(userList);
		session.setAttribute("USERS", userList);
		response.sendRedirect("dashboard.jsp");
	}
}
