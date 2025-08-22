package com.restro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.restro.model.ContactPojo;

public class ContactDaoImpl implements ContactDao {

	private String result;
	@Override
	public String saveContact(String name, String email, String subject, String message, String datetime) {
		
		Connection cn=null;
		try {
			 cn=Conection.getConnection(); 
			String sql="Insert into contact(name,email,subject,message,datetime) values(?,?,?,?,?)";
			PreparedStatement pst=cn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, subject);
			pst.setString(4, message);
			pst.setString(5, datetime);
			int i=pst.executeUpdate();
			if(i==1)
			{
			  result="MESSAGE SENT SUCCESSFULY";	
			}
			else
			{
				result="SOMETHING WENT WRONG";
			}
		}
		catch(Exception e)
		{
			result="SOMETHING WENT WRONG";
			e.printStackTrace();
			
		}
		finally {
			try
			{
				cn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public ArrayList<ContactPojo> readContact() {
		ArrayList<ContactPojo> arraylist=new ArrayList<ContactPojo>();
		
		Connection cn=null;
		try {
			 cn=Conection.getConnection(); 
			String sql="Select * from contact";
			PreparedStatement pst=cn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			if(!rs.next())
			{
				arraylist.add(new ContactPojo(0,"ne","ne","ne","ne","ne"));
			}
			else {
				
				  do
		    	{
				   arraylist.add(new ContactPojo(rs.getInt("sno"),rs.getString("name"),rs.getString("email"),rs.getString("subject"),rs.getString("message"),rs.getString("dateTime")));
			    }  
				 while(rs.next());
	    }			
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			arraylist.clear();
		}
		finally {
			try
			{
				cn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return arraylist;
	}
	@Override
	public String deleteContact(int sno) {
		Connection cn=null;
		try {
			 cn=Conection.getConnection(); 
			String sql="Delete from contact where sno=?";
			PreparedStatement pst=cn.prepareStatement(sql);
			pst.setInt(1, sno);
			int executeUpdate=pst.executeUpdate();
			if(executeUpdate == 1)
			{
				result="MESSAGE DELETED SUCCESSFULY";
			}
			else {
				result="SOMETHING WENT WRONG";
			}
			
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result="SOMETHING WENT WRONG";
		}
		finally {
			try
			{
				cn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	

}
