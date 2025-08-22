package com.restro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restro.service.contactserviceimpl1;

@WebServlet("/contactservlet1")
public class contactservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ses=request.getSession();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		
		contactserviceimpl1 contactserviceimpl1=new contactserviceimpl1();
		result=contactserviceimpl1.contactService1(name, email, subject, message);
		
	
		
		if(result.equals("VALID"))
		{
			result=contactserviceimpl1.contactService2(name, email, subject, message);  //it can also be done in anotehr servlet done in adminpanel
			ses.setAttribute("Message",result);
			response.sendRedirect("contact.jsp");
		}
		else
		{
			ses.setAttribute("Message",result);
			response.sendRedirect("contact.jsp");
		}
	}

}
