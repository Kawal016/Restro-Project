package com.restro.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.restro.dao.ContactDaoImpl;
import com.restro.dao.ServiceModuleDaoImpl;
import com.restro.model.ServicePojo;
import com.restro.validation.validationServiceModuleImpl;

public class ServiceModuleServiceImpl implements ServiceModuleService {

	private String result;
	@Override
	public String validateServiceModule(String iconname, String title, String description) {
		
		try {
			validationServiceModuleImpl validationServiceModuleImpl =new validationServiceModuleImpl();
			result=validationServiceModuleImpl.validateServiceModule(iconname, title , description);
		}
		catch(Exception e)
		{
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public String addServiceModule(String iconname, String title, String description) {
		try {
			String datetimes=LocalDateTime.now().toString();
			ServiceModuleDaoImpl  serviceModuleDaoImpl = new ServiceModuleDaoImpl();
			result=serviceModuleDaoImpl.saveServiceModule(iconname, title, description,datetimes);
		}
		catch(Exception e)
		{
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public ArrayList<ServicePojo> readService() {
		System.out.println("service read goes to dao");
		ArrayList<ServicePojo> arraylist = null;
		
		try {
			System.out.println("enter try block service");
		 ServiceModuleDaoImpl serviceModuleDaoImpl= new ServiceModuleDaoImpl();  
		 arraylist=serviceModuleDaoImpl.readAllService(); 
		}
		catch(Exception e)
		{
			System.out.println("SERVICE ERROR");
		 e.printStackTrace();	
		}
		System.out.println(arraylist);
		return arraylist;
	}
	@Override
	public ArrayList<ServicePojo> readfourService() {
		System.out.println("service read goes to dao for 4");
		ArrayList<ServicePojo> arraylist = null;
		
		try {
			System.out.println("enter try block service for 4");
		 ServiceModuleDaoImpl serviceModuleDaoImpl= new ServiceModuleDaoImpl();  
		 arraylist=serviceModuleDaoImpl.readfourService(); 
		}
		catch(Exception e)
		{
			System.out.println("SERVICE ERROR");
		 e.printStackTrace();	
		}
		System.out.println(arraylist);
		return arraylist;
	}
	@Override
	public String deleteService(String sno) {
		System.out.println("Enter in delete dao");
		try {
			int intsno=Integer.parseInt(sno);
			ServiceModuleDaoImpl serviceModuleDaoImpl=new ServiceModuleDaoImpl();
			result=serviceModuleDaoImpl.deleteServicedao(intsno);
		
		}
		catch(Exception e)
		{
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		 return result;
	}
	@Override
	public String updateServiceModule(String iconname, String title, String description, int sno) {
		try {
			
			ServiceModuleDaoImpl  serviceModuleDaoImpl = new ServiceModuleDaoImpl();
			result=serviceModuleDaoImpl.updateServiceModule(iconname, title, description,sno);
		}
		catch(Exception e)
		{
			result="SERVICE ERROR";
			e.printStackTrace();
		}
		return result;
	}

}

