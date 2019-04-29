package com.wedding.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wedding.daos.UserDao;
import com.wedding.daosimpl.UserDaoImpl;
import com.wedding.models.User;


@WebServlet("/validateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String s1=request.getParameter("email");
		String s2=request.getParameter("pwd");

		UserDao daoObj=new UserDaoImpl();
		User userObj=daoObj.validateUser(s1, s2);
		if(userObj!=null){
			HttpSession session=request.getSession();
			session.setAttribute("user",userObj);
		
			RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("msg","Email or Password is incorrect");
			RequestDispatcher rd=request.getRequestDispatcher("UserLogin.jsp");
			rd.forward(request, response);
		}

		}
}
