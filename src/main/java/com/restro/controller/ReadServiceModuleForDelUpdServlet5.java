package com.restro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restro.model.ServicePojo;
import com.restro.service.ServiceModuleServiceImpl;

@WebServlet("/ReadServiceModuleForDelUpdServlet5")
public class ReadServiceModuleForDelUpdServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		HttpSession ses=request.getSession();
		ServiceModuleServiceImpl serviceModuleServiceImpl = new  ServiceModuleServiceImpl();
		ArrayList<ServicePojo> arraylist =serviceModuleServiceImpl.readService();
		
		
		//same as before 4 possible outcome
		
		if(arraylist == null)
		{
			ses.setAttribute("Message","SOMETHING WENT WRONG: SERVICE LAYER");
			response.sendRedirect("ReadService.jsp");
			
			
		}
		else if(arraylist.isEmpty())
		{
			ses.setAttribute("Message","SOMETHING WENT WRONG : DAO LAYER");
			response.sendRedirect("ReadService.jsp");
			
		}
		else
		{
			String datetime=arraylist.get(0).getDateTime();
			if(datetime.equals("ne"))
			{
			 ses.setAttribute("Message","DATA DOES NOT EXIST");
			 response.sendRedirect("ReadService.jsp");
				
			}
			else
			{
				
			   ses.setAttribute("service2data", arraylist );
			   response.sendRedirect("ReadService.jsp");
		
			}
		}
		
	}
	}

	


