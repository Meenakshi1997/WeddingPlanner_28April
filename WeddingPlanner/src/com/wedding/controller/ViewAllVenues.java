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

import com.wedding.daos.VenueDao;
import com.wedding.daosimpl.VenueDaoImpl;


@WebServlet("/viewAllVenues")
public class ViewAllVenues extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		VenueDao venObj=new VenueDaoImpl();
		List<com.wedding.models.Venue> venuesList=venObj.getAllVenues();

		request.setAttribute("vList",venuesList);
		RequestDispatcher rd=request.getRequestDispatcher("ViewVenues.jsp");
		rd.forward(request, response);


	}

}
