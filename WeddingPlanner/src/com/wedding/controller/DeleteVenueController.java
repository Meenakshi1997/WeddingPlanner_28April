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


@WebServlet("/deleteVenue")
public class DeleteVenueController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();

	int id=Integer.parseInt(request.getParameter("VenueId"));

	VenueDao venDao=new VenueDaoImpl();
	boolean r=venDao.deleteVenue(id);
	if(r==true){
		request.setAttribute("msg","Venue Deleted Succesfully");
	}
	else {
		request.setAttribute("msg","Problem in Deleting Venue . Try again");
	}
	request.setAttribute("vList",venDao.getAllVenues());
	RequestDispatcher rd=request.getRequestDispatcher("ViewVenues.jsp");
	rd.forward(request, response);

	}

}