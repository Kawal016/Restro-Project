package com.restro.validation;

public class contactValidationImpl implements contactvalidation {

	private String result;
	
	@Override
	public String contactValidation(String name, String email, String subject, String message) {
		
		try {
		int namelen=name.length();
		int emaillen=email.length();
		int subjectlen=subject.length();
		int messagelen=message.length();
		
		if(namelen<2 || namelen>50)
		{
			result= "INVALID NAME";
		}
		else if(emaillen<10 || emaillen>50 || !email.contains("@"))
		{
			result= "INVALID EMAIL";
		}
		else if(subjectlen<20 || subjectlen>80 )
		{
			result="INVALID SUBJECT";
		}
		else if(messagelen<10 || messagelen>500 )
		{
			result= "INVALID MESSAGE";
		}
		else
		{
			return "VALID";
		}
	}
		catch(Exception e)
		{
			result="SERVICE ERROR";
			e.printStackTrace();
			
		}
		return result;
	}

}
