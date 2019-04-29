package com.wedding.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wedding.daos.CateringDao;
import com.wedding.daosimpl.CateringDaoImpl;



@WebServlet("/viewAllCaterings")
public class ViewAllCaterings extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		CateringDao catObj=new CateringDaoImpl();
		List<com.wedding.models.Catering> cateringsList=catObj.getAllCaterings();

		request.setAttribute("cList",cateringsList);
		RequestDispatcher rd=request.getRequestDispatcher("ViewCaterings.jsp");
		rd.forward(request, response);


	}

}
