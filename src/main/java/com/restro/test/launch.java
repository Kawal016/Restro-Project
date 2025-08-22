package com.restro.test;

import java.util.ArrayList;

import com.restro.dao.ServiceModuleDaoImpl;
import com.restro.model.ServicePojo;

public class launch {

	public static void main(String[] args) {
		
		 ServiceModuleDaoImpl c= new  ServiceModuleDaoImpl();
		 ArrayList<ServicePojo> arraylist=c.readfourService();
		for(ServicePojo k:arraylist)
		{
			System.out.println(k);
		}
		
	}

}
