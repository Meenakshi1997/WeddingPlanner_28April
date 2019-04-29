package com.wedding.controller;

import java.io.IOException;

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


@WebServlet("/changePassword")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		String str=user.getEmail();
		
		//String s1=request.getParameter("password");
		String s1=request.getParameter("newpassword");
		String s2=request.getParameter("confirmpassword");

		System.out.println("In controller : "+str+" "+s1+" "+s2);
		
		if(s1.equals(s2)){
			UserDao changePasswordObj=new UserDaoImpl();
			boolean obj=changePasswordObj.changePassword(str, s1,s2);
			System.out.println(obj);
			if(obj==true){
				RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
				request.setAttribute("errorMsg","success");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
				request.setAttribute("errorMsg","failed");
				rd.forward(request, response);
			}
		}
		
	}

}
