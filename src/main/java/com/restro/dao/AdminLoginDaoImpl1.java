package com.restro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDaoImpl1 implements AdminLoginDao1 {

	private String result;
	@Override
	public String adminLoginDaofnc1(String username, String password) {

		 Connection cn=null;
       try {
    	    cn=Conection.getConnection(); 
    	   String query="Select * from AdminPanel where Username=? and Password=?";
    	   PreparedStatement pst=cn.prepareStatement(query);
    	   pst.setString(1,username);
    	   pst.setString(2, password);
    	   ResultSet rs=pst.executeQuery();
    	   if(rs.next())
    	   {
    		   result="EXIST";
    		   
    	   }
    	   else
    	   {
    		   result="NOT EXIST";
    	   }
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
    	   result="FAILED";
       }
       finally {
    	   try {
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
