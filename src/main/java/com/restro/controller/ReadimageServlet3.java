package com.restro.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restro.service.AboutUploadImageSeviceImpl1;


@WebServlet("/ReadimageServlet3")
public class ReadimageServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses=request.getSession();
	    int id=Integer.parseInt(request.getParameter("id"));
	    System.out.println("ENTER IN SERVLET RAED IMAGE");
	    AboutUploadImageSeviceImpl1 aboutUploadImageSeviceImpl1=new AboutUploadImageSeviceImpl1();
	  
	   
	    byte[] img=aboutUploadImageSeviceImpl1.readImage(id);
	    
	    if(img!=null)
	    {
	    	System.out.println("EXIST IN SERVLET RAED IMAGE");
	    	response.setContentType("image/jpeg");
	    	OutputStream out= response.getOutputStream();
	    	out.write(img);
	    	out.close();
	    }
	    else
	    {
	    	ses.setAttribute("Message","IMAGES ARE NOT AVILABLE ON THIS TIME");
	    	response.sendRedirect("Message.jsp");
	    }
	}



}
