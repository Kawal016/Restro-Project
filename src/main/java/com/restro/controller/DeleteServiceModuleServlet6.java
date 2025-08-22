package com.restro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restro.service.ServiceModuleServiceImpl;


@WebServlet("/DeleteServiceModuleServlet6")
public class DeleteServiceModuleServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private String result;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enter in delete servlet");
		HttpSession ses=request.getSession();
		String sno=request.getParameter("sno");
		System.out.println("Value of sno" + sno);
		
		ServiceModuleServiceImpl serviceModuleServiceImpl=new ServiceModuleServiceImpl();
		result=serviceModuleServiceImpl.deleteService(sno);
		
		ses.setAttribute("Message", result);
		response.sendRedirect(" ReadServiceModuleForDelUpdServlet5");
	}

}
