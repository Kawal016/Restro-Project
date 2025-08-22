package com.restro.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.restro.service.AboutUploadImageSeviceImpl1;

@MultipartConfig()
@WebServlet("/AboutUploadImageServlet1")
public class AboutUploadImageServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ses=request.getSession();
		InputStream Is=null;
		Part filepart=request.getPart("image");
		if(filepart!=null)
		{
			Is=filepart.getInputStream();
		}
		AboutUploadImageSeviceImpl1 aboutUploadImageSeviceImpl1= new AboutUploadImageSeviceImpl1();
		result=aboutUploadImageSeviceImpl1.uploadimageservice(Is);
		if(result.contains("SUCCESSFULY"))
		{
			ses.setAttribute("Message",result);
			response.sendRedirect("AboutAdmin.jsp");
		}
		else
		{
			ses.setAttribute("Message",result);
			response.sendRedirect("AboutAdmin.jsp");
		}
	}

}
