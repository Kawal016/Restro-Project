package com.restro.service;

import java.util.ArrayList;

import com.restro.model.ContactPojo;

public interface contactservice {

	public String contactService1(String name,String email,String subject,String message);
	
	public String contactService2(String name,String email,String subject,String message);
	
	public ArrayList<ContactPojo> readContactService();
	
	public String deleteService(String sno);
}
