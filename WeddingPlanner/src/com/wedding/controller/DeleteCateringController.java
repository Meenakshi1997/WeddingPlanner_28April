package com.wedding.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wedding.daos.CateringDao;
import com.wedding.daosimpl.CateringDaoImpl;

@WebServlet("/deleteCatering")
public class DeleteCateringController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		int id=Integer.parseInt(request.getParameter("catererId"));

		CateringDao catDao=new CateringDaoImpl();
		boolean r=catDao.deleteCaterer(id);
		if(r==true){
			request.setAttribute("msg","Catering Deleted Succesfully");
		}
		else {
			request.setAttribute("msg","Problem in Deleting catering . Try again");
		}
		request.setAttribute("cList",catDao.getAllCaterings());
		RequestDispatcher rd=request.getRequestDispatcher("ViewCaterings.jsp");
		rd.forward(request, response);

	}

}
