package com.registration.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.registration.dao.UserDAO;
import com.registration.dao.impl.UserDAOImpl;
import com.registration.model.User;

/**
 * Servlet implementation class DeleteUserServlet
 */
//@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
	public void init() {
		userDao = new UserDAOImpl();
	} 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//delete the record in db
		//get the user from db
		int id = Integer.parseInt(request.getParameter("id"));
        userDao.deleteUser(id);
        List<User> userList=userDao.getAllActiveUsers();
        HttpSession session=request.getSession();
        session.setAttribute("USERS", userList);
        response.sendRedirect("dashboard.jsp");
	}

}
