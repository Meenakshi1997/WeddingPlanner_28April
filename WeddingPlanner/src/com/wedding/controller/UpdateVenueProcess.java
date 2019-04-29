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

import com.wedding.daos.VenueDao;
import com.wedding.daosimpl.VenueDaoImpl;
import com.wedding.models.Venue;

@MultipartConfig
@WebServlet("/updateVenueProcess")
public class UpdateVenueProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			int id=Integer.parseInt(request.getParameter("venueId"));
			String name=request.getParameter("venueName");
			int price=Integer.parseInt(request.getParameter("price"));
			String loc=request.getParameter("location");
			Part filePart=request.getPart("image");
			

			Venue venObj=new Venue();
			venObj.setVenueId(id);
			venObj.setVenueName(name);
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
			
			VenueDao daoObj=new VenueDaoImpl();
			boolean r=daoObj.updateVenue(venObj);
			if(r){
				List<Venue> venuesList=daoObj.getAllVenues();

				request.setAttribute("vList",venuesList);

				request.setAttribute("msg","Venue Updated Succesfully");
				RequestDispatcher rd=request.getRequestDispatcher("ViewVenues.jsp");
				rd.forward(request, response);
			}
			else {

			}
	}

}
