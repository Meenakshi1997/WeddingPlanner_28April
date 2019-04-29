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
import com.wedding.models.Venue;
import com.wedding.daos.CateringDao;
import com.wedding.daosimpl.CateringDaoImpl;
import com.wedding.models.Catering;
import com.wedding.daos.VendorDao;
import com.wedding.daosimpl.VendorDaoImpl;
import com.wedding.models.Vendor;

@WebServlet("/fetchSubCategories")

public class FetchSubCategoriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		int catId=Integer.parseInt(request.getParameter("category"));
		
		if(catId==64)//catering
		{
			CateringDao catDao=new CateringDaoImpl();
			List<Catering> catering=catDao.getAllCaterings();
			request.setAttribute("cList",catering);
			RequestDispatcher rd=request.getRequestDispatcher("ViewCaterings.jsp");
			rd.forward(request,response);
			
		}
		else if(catId==81)//Vendors
		{
			VendorDao vendorDao=new VendorDaoImpl();
			List<Vendor> venue=vendorDao.getAllVendors();
			request.setAttribute("vList", venue);
			RequestDispatcher rd=request.getRequestDispatcher("ViewVendors.jsp");
			rd.forward(request, response);
			
		}
		else if(catId==61) //Venues 
		{
			VenueDao venueDao=new VenueDaoImpl();
			List<Venue> venue=venueDao.getAllVenues();
			request.setAttribute("vList", venue);
			RequestDispatcher rd=request.getRequestDispatcher("ViewVenues.jsp");
			rd.forward(request, response);
		}
			
	}

}                     
