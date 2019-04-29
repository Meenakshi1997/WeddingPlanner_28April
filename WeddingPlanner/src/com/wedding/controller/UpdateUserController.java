package com.wedding.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;

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


@WebServlet("/updateUser")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
    	PrintWriter out=response.getWriter();

    	String s1=request.getParameter("email");
        //String s2=request.getParameter("pwd");
    	String s3=request.getParameter("fName");
    	String s4=request.getParameter("lName");
    	String s5=request.getParameter("gender");
    	//String s6=request.getParameter("dob");
    	String s7=request.getParameter("address");
    	String s8=request.getParameter("mob");

    	//Converting String into java.util.Date
    	/*SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    	Date dob=null;*/
		try {
			//dob = sdf.parse(s6);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

    	User ur=new User();
    	ur.setEmail(s1);
    	//userObj.setPassword(s2);
    	ur.setFirstName(s3);
    	ur.setLastName(s4);
    	ur.setGender(s5);
    //	ur.setDateOfBirth(dob);
    	ur.setAddress(s7);
    	ur.setMobileNo(s8);
    	
    	UserDao dao=new UserDaoImpl();
    	boolean r=dao.updateUser(ur);
    	System.out.println(r);
    	if(r){
    		HttpSession session=request.getSession();
    		request.setAttribute("msg", "User updated Succesfully");
    		session.setAttribute("user",ur);
    		
    		RequestDispatcher rd=request.getRequestDispatcher("ViewProfile.jsp");
    		rd.forward(request, response);
    	}
    	else {
    		RequestDispatcher rd=request.getRequestDispatcher("UpdateProfile.jsp");
    		rd.forward(request, response);

    	}

	}

	}


