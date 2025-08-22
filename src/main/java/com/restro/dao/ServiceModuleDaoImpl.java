package com.restro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.restro.model.ServicePojo;

public class ServiceModuleDaoImpl implements ServiceModuleDao {

	private String result;
	@Override
	public String saveServiceModule(String iconname, String title, String description,String datetime) {
		Connection con=null;
		try {
			con=Conection.getConnection();
			String sql="Insert into serviceModule(iconname,title,description,datetimes) values (?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,iconname);
			pst.setString(2,title);
			pst.setString(3,description);
			pst.setString(4,datetime);
		    int i=pst.executeUpdate();
		    if(i==1)
		    {
		      result="SERVICE ADDED SUCCESSFULY";
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
			try {
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public ArrayList<ServicePojo> readAllService() {
		System.out.println("enter in dao read");
		Connection con=null;
		ArrayList<ServicePojo> arraylist = new ArrayList<ServicePojo>(); 
		try {
			System.out.println("enter dao try block");
			con=Conection.getConnection();
			String sql="Select * from serviceModule";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			if(!rs.next())
			{
				arraylist.add(new ServicePojo(0,"ne","ne","ne","ne"));
			}
			else
			{
				do
				{
				ServicePojo sp=new ServicePojo(rs.getInt("sNo"),rs.getString("iconName"),rs.getString("title"),rs.getString("description"),rs.getString("datetimes"));
			   arraylist.add(sp);
				}
				while(rs.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("error in dao catch block");
			e.printStackTrace();
			arraylist.clear();
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("enter in finally block");
				e.printStackTrace();
			}
		}
		System.out.println(arraylist);
		return arraylist;
	}
	@Override
	public ArrayList<ServicePojo> readfourService() {
	    	
		
		Connection con=null;
		ArrayList<ServicePojo> arraylist = new ArrayList<ServicePojo>(); 
		try {
			System.out.println("enter dao try block readfourservice");
			con=Conection.getConnection();
			String sql="Select * from serviceModule LIMIT 4";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			if(!rs.next())
			{
				arraylist.add(new ServicePojo(0,"ne","ne","ne","ne"));
			}
			else
			{
				do
				{
				ServicePojo sp=new ServicePojo(rs.getInt("sNo"),rs.getString("iconName"),rs.getString("title"),rs.getString("description"),rs.getString("datetimes"));
			   arraylist.add(sp);
				}
				while(rs.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("error in dao catch block for 4");
			e.printStackTrace();
			arraylist.clear();
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("enter in finally block for 4");
				e.printStackTrace();
			}
		}
		
		return arraylist;
	}
	@Override
	public String deleteServicedao(int sno) {
		System.out.println("Enter in delete service");
		Connection cn=null;
		try {
			 cn=Conection.getConnection(); 
			String sql="Delete from serviceModule where sno=?";
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
	@Override
	public String updateServiceModule(String iconname, String title, String description, int sno) {
		Connection con=null;
		try {
			con=Conection.getConnection();
			String sql="Update  serviceModule SET iconname=?,title=?,description=? WHERE sno=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,iconname);
			pst.setString(2,title);
			pst.setString(3,description);
			pst.setInt(4, sno);
			
		    int i=pst.executeUpdate();
		    if(i==1)
		    {
		      result="SERVICE UPDATED SUCCESSFULY";
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
			try {
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	

}
