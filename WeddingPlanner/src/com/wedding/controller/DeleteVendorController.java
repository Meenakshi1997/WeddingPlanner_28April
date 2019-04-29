package com.wedding.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wedding.daos.VendorDao;
import com.wedding.daosimpl.VendorDaoImpl;


@WebServlet("/deleteVendor")
public class DeleteVendorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();

	int id=Integer.parseInt(request.getParameter("vendorId"));

	VendorDao venDao=new VendorDaoImpl();
	boolean r=venDao.deleteVendor(id);
	if(r==true){
		request.setAttribute("msg","Vendor Deleted Succesfully");
	}
	else {
		request.setAttribute("msg","Problem in Deleting Vendor . Try again");
	}
	request.setAttribute("vList",venDao.getAllVendors());
	RequestDispatcher rd=request.getRequestDispatcher("ViewVendors.jsp");
	rd.forward(request, response);

	}

}