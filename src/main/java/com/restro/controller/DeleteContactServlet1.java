package com.restro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restro.service.contactserviceimpl1;

@WebServlet("/DeleteContactServlet1")
public class DeleteContactServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String result;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
	
		HttpSession ses=request.getSession();
		String sno=request.getParameter("sNo");
		contactserviceimpl1 contactserviceimpl1=new contactserviceimpl1();
		 result=contactserviceimpl1.deleteService(sno);
		
		ses.setAttribute("Message", result);
		response.sendRedirect("ReadMessageServlet1");
		
	}

}
