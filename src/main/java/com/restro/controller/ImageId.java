package com.restro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restro.service.AboutUploadImageSeviceImpl1;


@WebServlet("/ImageId")
public class ImageId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses=request.getSession();
	    ses.setAttribute("Check","from servlet");
	    System.out.println("ENTER IN SERVLET RAED IMAGEID");
	     AboutUploadImageSeviceImpl1  aboutUploadImageSeviceImpl1=new  AboutUploadImageSeviceImpl1();
		 List<Integer> imageIds=aboutUploadImageSeviceImpl1.readimageservice();
		 
		 if (imageIds != null && !imageIds.isEmpty())
		 {
			 System.out.println("EXIST IN SERVLET RAED IMAGEID");
				ses.setAttribute("AboutImage", imageIds);
				response.sendRedirect("about.jsp");
			} 
		 else {
				ses.setAttribute("Message", "IMAGES NOT AVAILABLE");
				response.sendRedirect("about.jsp");
			}
		 
	}

	

}
