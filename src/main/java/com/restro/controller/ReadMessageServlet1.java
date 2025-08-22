package com.restro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restro.model.ContactPojo;
import com.restro.service.contactserviceimpl1;


@WebServlet("/ReadMessageServlet1")
public class ReadMessageServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession ses=request.getSession(); 
	contactserviceimpl1 contactserviceimpl1 = new contactserviceimpl1();
	ArrayList<ContactPojo> arraylist=contactserviceimpl1.readContactService();
	ses.setAttribute("Check", "fromservlet");
	//4 possible outcome of arraylist
	
	if(arraylist==null)
	{  
		//return null  service exception
		ses.setAttribute("Message","SOMETHING WENT WRONG : SERVICE LAYER");
		response.sendRedirect("AdminPanel.jsp");
	}
	else if(arraylist.isEmpty())
	{
		//return clear  dao exception
		ses.setAttribute("Message","SOMETHING WENT WRONG : DAO LAYER");
		response.sendRedirect("AdminPanel.jsp");
	}
	else
	{
		//return ne  data not exist
		String datetime=arraylist.get(0).getDateTime();
		if(datetime.equals("ne"))
		{
			ses.setAttribute("Message","DATA NOT EXIST");
			response.sendRedirect("AdminPanel.jsp");
		}
		else
		{   
			//return pojo  //data exist
			ses.setAttribute("contactdata",arraylist);
			response.sendRedirect("Readcontact.jsp");
		}
	}
	
	
	
	
	}



}
