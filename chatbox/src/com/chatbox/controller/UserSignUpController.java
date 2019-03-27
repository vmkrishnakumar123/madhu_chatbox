package com.chatbox.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chatbox.dao.UserDao;
import com.chatbox.db.HibernateUtil;
import com.chatbox.entities.User;
import com.chatbox.services.UserServices;

/**
 * Servlet implementation class UserSignUpController
 */
public class UserSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// get input from signup form
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String  status ="deactivated";
		
		

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setActivationStatus(status);
		HibernateUtil hbUtil=new HibernateUtil();
		
		UserDao dao = new UserDao(hbUtil);
		UserServices services = new UserServices(dao);
		int res=services.saveUser(user);
		

PrintWriter out = response.getWriter();
		if(res==1)
		{
			out.println("You are already in our data base<br> Please Login here");
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			rd.include(request, response);
		}
		else if(res==2)
		{
			out.println("You are Successfully Registered<br> Please Login here");
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			rd.include(request, response);
		}
		else 
		{
			out.println("Please try again");
			RequestDispatcher rd = request.getRequestDispatcher("usersignup.html");
			rd.include(request, response);
			
		}
		


	}

}
