package com.restro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restro.service.ServiceModuleServiceImpl;

/**
 * Servlet implementation class ServiceModuleServlet1
 */
@WebServlet("/ServiceModuleServlet1")
public class ServiceModuleServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private  String result;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession ses=request.getSession();
		String iconname=request.getParameter("iconname");
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		
		ServiceModuleServiceImpl ServiceModuleServiceImpl =new ServiceModuleServiceImpl();
		result=ServiceModuleServiceImpl.validateServiceModule(iconname, title, description);	
		
		if(result.equals("VALID"))
		{
			//Forward next servlet for store dao
		    RequestDispatcher rd=request.getRequestDispatcher("ServiceModuleServlet2");
		    rd.forward(request, response);
		}
		else
		{
			ses.setAttribute("Message", result);
			response.sendRedirect("AddService.jsp");
		}
	}

}
