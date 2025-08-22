package com.restro.service;

import com.restro.dao.AdminLoginDaoImpl1;
import com.restro.validation.AdminLoginValidationImpl1;

public class AdminLoginServiceImpl1 implements AdminLoginService1 {

	private String result;
	@Override
	public String adminLoginService1(String username, String Password) {
		
		try {
			AdminLoginValidationImpl1 AdminLoginValidationImpl1 = new AdminLoginValidationImpl1(); 
			result=AdminLoginValidationImpl1.adminLoginValidation(username, Password); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result="SERVICE ERROR";
		}
		return result;
	}
	@Override
	public String adminLoginService2(String username, String Password) {
		try {
			AdminLoginDaoImpl1 adminLoginDaoImpl1 = new AdminLoginDaoImpl1();
			result=adminLoginDaoImpl1.adminLoginDaofnc1(username, Password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result="SERVICE ERROR";
		}
		return result;
	}

}
