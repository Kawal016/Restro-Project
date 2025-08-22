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


@WebServlet("/ReadServiceModuleServlet4")
public class ReadServiceModuleServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet read goes to service for 4");
		HttpSession ses=request.getSession();
		ServiceModuleServiceImpl serviceModuleServiceImpl = new  ServiceModuleServiceImpl();
		ArrayList<ServicePojo> arraylist =serviceModuleServiceImpl.readfourService();
		System.out.println("enter in read servlet value of array for 4 "+ arraylist);
		ses.setAttribute("check","fromservlet");
		//same as before 4 possible outcome
		
		if(arraylist == null)
		{
			ses.setAttribute("Message","SERVICE UNAVAILABLE");
			response.sendRedirect("index.jsp");
			
			
		}
		else if(arraylist.isEmpty())
		{
			ses.setAttribute("Message","SERVICE UNAVAILABLE");;
			response.sendRedirect("index.jsp");
			
		}
		else
		{
			String datetime=arraylist.get(0).getDateTime();
			if(datetime.equals("ne"))
			{
			 ses.setAttribute("Message","SERVICE DOES NOT EXIST");
			 response.sendRedirect("index.jsp");
				
			}
			else
			{
				System.out.println("data save successfuly");
			   ses.setAttribute("service1data", arraylist );
			   response.sendRedirect("index.jsp");
		
			}
		}
		
	}
	}


