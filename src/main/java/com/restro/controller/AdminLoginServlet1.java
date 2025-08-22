package com.restro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restro.service.AdminLoginServiceImpl1;

@WebServlet("/AdminLoginServlet1")
public class AdminLoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String result;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession ses=request.getSession();
		
		AdminLoginServiceImpl1 	AdminLoginServiceImpl1 = new AdminLoginServiceImpl1();
		String result=AdminLoginServiceImpl1.adminLoginService1(user, password);
		if(result.equals("VALID"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("AdminLoginServlet2");
			rd.forward(request, response);
			
		}
		else
		{
			ses.setAttribute("Message", result);
			response.sendRedirect("AdminLogin.jsp");
		}
		response.setHeader("Cache-Control", "no-Cache,no-store,must-revalidate");
	}
     
}
