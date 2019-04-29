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
import com.wedding.models.Catering;

@WebServlet("/updateCatering")
public class UpdateCateringController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();

	int id=Integer.parseInt(request.getParameter("catererId"));

	CateringDao catDao=new CateringDaoImpl();
	Catering cat=catDao.getCatererById(id);
                                                                                                
	request.setAttribute("cateringObj",cat);
	RequestDispatcher rd=request.getRequestDispatcher("UpdateCateringForm.jsp");
	rd.forward(request, response);

	}

}