package com.restro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restro.service.AdminLoginServiceImpl1;


@WebServlet("/AdminLoginServlet2")
public class AdminLoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private  String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession ses=request.getSession();
		
		String user=request.getParameter("username");
		String Password=request.getParameter("password");
		
	  	AdminLoginServiceImpl1 adminLoginServiceImpl1 = new AdminLoginServiceImpl1();
		result= adminLoginServiceImpl1.adminLoginService2(user, Password);
		if(result.equals("EXIST"))
		{
			ses.setAttribute("AdminLogin", user);
			
			response.sendRedirect("AdminPanel.jsp");  //forwar to adminpanel page
			
		}
		else
		{
			ses.setAttribute("Message","NOT EXIST");
			response.sendRedirect("AdminLogin.jsp");
		}
		
	}

}
