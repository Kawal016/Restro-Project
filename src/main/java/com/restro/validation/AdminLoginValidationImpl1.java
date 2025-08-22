package com.restro.validation;

public class AdminLoginValidationImpl1 implements AdminLoginValidation1 {
  
	 private String result;
	@Override
	public String adminLoginValidation(String username, String password) {
		try {
			int userlen=username.length();
			int passlen=password.length();
		    
			if(userlen<6 || userlen>16)
			{
				result="INVALID USERNAME";
			}
			else if(passlen<6 || passlen>16)
			{
				result="INVALID PASSWORD";
			}
			else
			{
				result="VALID";
			}
		}
		catch(Exception e)
		{
	
			e.printStackTrace();
			result="SOMETHING WENT WRONG";
		}
		return result;
	}

}
