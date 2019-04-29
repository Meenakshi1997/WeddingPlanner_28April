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

import com.wedding.daos.VendorDao;
import com.wedding.daosimpl.VendorDaoImpl;

@WebServlet("/viewAllVendors")
public class ViewAllVendors extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		VendorDao venObj=new VendorDaoImpl();
		List<com.wedding.models.Vendor> vendorsList=venObj.getAllVendors();

		request.setAttribute("vList",vendorsList);
		RequestDispatcher rd=request.getRequestDispatcher("ViewVendors.jsp");
		rd.forward(request, response);
	}

}
