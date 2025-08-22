package com.restro.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conection {

	private static String username="root";
	private static String password="Kawa@123";
	private static String url="jdbc:mysql://localhost:3306/restro";
	private static Connection con;
	private static String classname="com.mysql.cj.jdbc.Driver";
	
	public static Connection getConnection() 
	{
	   	try {
			Class.forName(classname);
		 	con=DriverManager.getConnection(url, username, password);
		} 
	   	catch (Exception e) {
			
			e.printStackTrace();
		}
	 return con; 
	}
}
