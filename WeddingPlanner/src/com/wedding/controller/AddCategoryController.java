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


import com.wedding.daos.CategoryDao;
import com.wedding.daosimpl.CategoryDaoImpl;
import com.wedding.models.Category;


@WebServlet("/addCategory")

public class AddCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String name=request.getParameter("categoryName");
		String d=request.getParameter("desc");

		Category catObj=new Category();
		catObj.setCategoryName(name);
		catObj.setCategoryDesc(d);
				

		
		CategoryDao daoObj=new CategoryDaoImpl();
		boolean r=daoObj.addCategory(catObj);
		if(r){
			List<Category> categoriesList=daoObj.getAllCategories();

			request.setAttribute("cList",categoriesList);
			request.setAttribute("msg","Category Added Succesfully");
			RequestDispatcher rd=request.getRequestDispatcher("ViewCategories.jsp");
			rd.forward(request, response);
		}
		else {

		}                                                                
	
	}

}                     
