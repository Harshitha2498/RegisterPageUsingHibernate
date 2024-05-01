package com.registration.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registration.dao.UserDAO;
import com.registration.dao.impl.UserDAOImpl;
import com.registration.model.User;

/**
 * Servlet implementation class ReadFile
 */
//@WebServlet("/ReadFile")

public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;

	public void init() {
		userDao = new UserDAOImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//read the data from table
		//fetch the result in another page with headings
		User user=new User();
		String id = request.getParameter("id");
		if(id!=null && Integer.valueOf(id)>0) {
			user.setId(Integer.valueOf(id));
			user = userDao.findById(user.getId());
			response.getWriter().write(user.toString());
		}else {
			response.getWriter().write("No Data");
		}
	}
}
