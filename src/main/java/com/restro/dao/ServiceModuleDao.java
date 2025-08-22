package com.restro.dao;

import java.util.ArrayList;

import com.restro.model.ServicePojo;

public interface ServiceModuleDao {

	public String saveServiceModule(String iconname,String title,String description,String datetime);
	public ArrayList<ServicePojo> readAllService();
	public ArrayList<ServicePojo> readfourService();
	public String deleteServicedao(int sno);
	public String updateServiceModule(String iconname,String title,String description,int sno);
	
}
