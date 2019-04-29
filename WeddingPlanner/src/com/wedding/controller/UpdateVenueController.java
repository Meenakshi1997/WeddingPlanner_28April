package com.wedding.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wedding.daos.VenueDao;
import com.wedding.daosimpl.VenueDaoImpl;
import com.wedding.models.Venue;

@WebServlet("/updateVenue")
public class UpdateVenueController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();

	int id=Integer.parseInt(request.getParameter("VenueId"));

	VenueDao venDao=new VenueDaoImpl();
	Venue ven=venDao.getVenueById(id);
                                                                                                
	request.setAttribute("venueObj",ven);
	RequestDispatcher rd=request.getRequestDispatcher("UpdateVenueForm.jsp");
	rd.forward(request, response);

	}

}