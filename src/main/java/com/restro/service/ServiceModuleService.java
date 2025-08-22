package com.restro.service;

import java.util.ArrayList;

import com.restro.model.ServicePojo;

public interface ServiceModuleService {

	public String validateServiceModule(String iconname,String title,String description);
	public String addServiceModule(String iconname,String title,String description);
	public ArrayList<ServicePojo> readService();
	public ArrayList<ServicePojo> readfourService();
	public String deleteService(String sno);
	public String updateServiceModule(String iconname,String title,String description,int sno);
}
