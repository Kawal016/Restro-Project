package com.restro.dao;

import java.util.ArrayList;

import com.restro.model.ContactPojo;

public interface ContactDao {

	public String saveContact(String name,String email,String subject,String message,String datetime);
	
	public ArrayList<ContactPojo> readContact();
	
	public String deleteContact(int sno);
}
