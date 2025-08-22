package com.restro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restro.service.ServiceModuleServiceImpl;


@WebServlet("/updateServlet1")
public class updateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String result;   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses=request.getSession();
		String iconname=request.getParameter("icon");
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		int sno=Integer.parseInt(request.getParameter("sno"));
		
		int index=Integer.parseInt(request.getParameter("index"));
	
		try {
		ServiceModuleServiceImpl serviceModuleServiceImpl = new ServiceModuleServiceImpl();
		result=serviceModuleServiceImpl.updateServiceModule(iconname, title, description, sno);
		String check=result;
		
		if(result.contains("SUCCESSFULY"))
		{
			ses.setAttribute("Message",result);
			response.sendRedirect("UpdateService.jsp?index=" + index);
		}
		else
		{
			ses.setAttribute("Message", result);
			response.sendRedirect("UpdateService.jsp?index=" + index);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
