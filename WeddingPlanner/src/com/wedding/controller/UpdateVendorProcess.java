package com.wedding.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.wedding.daos.VendorDao;
import com.wedding.daosimpl.VendorDaoImpl;
import com.wedding.models.Vendor;

@MultipartConfig
@WebServlet("/updateVendorProcess")
public class UpdateVendorProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			int id=Integer.parseInt(request.getParameter("vendorId"));
			String name=request.getParameter("vendorName");
			int price=Integer.parseInt(request.getParameter("price"));
			String loc=request.getParameter("location");
			Part filePart=request.getPart("image");
			

			Vendor venObj=new Vendor();
			venObj.setVendorId(id);
			venObj.setVendorName(name);
			venObj.setPrice(price);
			venObj.setLocation(loc);
			venObj.setImage(filePart.getSubmittedFileName());
			
			String fileName=filePart.getSubmittedFileName();
			System.out.println("File Name : "+fileName);

			HttpSession session=request.getSession();
			String serverLocation=session.getServletContext().getRealPath("/");
			System.out.println(serverLocation);

			String filePath=serverLocation+"images";
			System.out.println("filePath : "+filePath);

			File fileObj=new File(filePath);
			if(!fileObj.exists()){
				fileObj.createNewFile();
			}

			InputStream is=filePart.getInputStream();
			BufferedInputStream bis=new BufferedInputStream(is);

			FileOutputStream fos=new FileOutputStream(filePath+"/"+fileName+".jpg");
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			int ch;
			while((ch=bis.read())!=-1){
				bos.write(ch);
			}

			bos.close();
			fos.close();
			
			VendorDao daoObj=new VendorDaoImpl();
			boolean r=daoObj.updateVendor(venObj);
			if(r){
				List<Vendor> vendorsList=daoObj.getAllVendors();

				request.setAttribute("vList",vendorsList);

				request.setAttribute("msg","Vendor Updated Succesfully");
				RequestDispatcher rd=request.getRequestDispatcher("ViewVendors.jsp");
				rd.forward(request, response);
			}
			else {

			}
	}

}
