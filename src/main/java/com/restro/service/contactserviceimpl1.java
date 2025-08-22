package com.restro.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.restro.dao.ContactDaoImpl;
import com.restro.model.ContactPojo;
import com.restro.validation.contactValidationImpl;

public class contactserviceimpl1 implements contactservice {

	private String result;
	
	@Override
	public String contactService1(String name, String email, String subject, String message) {
		
		try {
			contactValidationImpl contactValidationImpl=new contactValidationImpl();
			result=contactValidationImpl.contactValidation(name, email, subject, message);   
			
		}
		catch(Exception e)
		{
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String contactService2(String name, String email, String subject, String message) {
		
		try {
			String datetime=LocalDateTime.now().toString();
			ContactDaoImpl contactDaoImpl=new ContactDaoImpl();
			result=contactDaoImpl.saveContact(name, email, subject, message, datetime);
		}
		catch(Exception e)
		{
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<ContactPojo> readContactService() {
		ArrayList<ContactPojo> arraylist=null;
		try {
			ContactDaoImpl contactDaoImpl=new ContactDaoImpl();
			   arraylist= contactDaoImpl.readContact();
			}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return arraylist;
	}

	@Override
	public String deleteService(String sno) {
		try {
			int intsno=Integer.parseInt(sno);
			ContactDaoImpl ContactDaoImpl=new ContactDaoImpl();
			result=ContactDaoImpl.deleteContact(intsno);
		
		}
		catch(Exception e)
		{
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		 return result;
	}

}
