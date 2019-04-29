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

import com.wedding.daos.LoginDao;
import com.wedding.daos.UserDao;
import com.wedding.daosimpl.LoginDaoImpl;
import com.wedding.daosimpl.UserDaoImpl;
import com.wedding.models.Login;
import com.wedding.models.User;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("email");
		String s2=request.getParameter("pwd");
		
		LoginDao loginDaoObj=new LoginDaoImpl();
		Login obj=loginDaoObj.validate(s1,s2);
		if(obj==null) {
		
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			request.setAttribute("errorMsg","Email or Password is incorrect");
			rd.forward(request, response);
		}
		else {
			String role=obj.getRole();
			
			
			if(role.equals("Admin")) {
				
				
				 System.out.println( " Role  is  Admin");
				
				UserDao ud=new UserDaoImpl();
				User userObj=ud.getUser(s1);
				userObj.setRole("Admin");
				
				System.out.println(userObj);
				
				HttpSession session=request.getSession();
				session.setAttribute("user",userObj);
				
				
				RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
				rd.forward(request, response);
			}
			else if(role.equals("user")){
				UserDao ud=new UserDaoImpl();
				User userObj=ud.getUser(s1);
				userObj.setRole("user");
				
				HttpSession session=request.getSession();
				session.setAttribute("user",userObj);
				session.setAttribute("user1", userObj);
				RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
				rd.forward(request, response);
				
			}
	}

	}
}