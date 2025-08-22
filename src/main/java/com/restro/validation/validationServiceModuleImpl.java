package com.restro.validation;

public class validationServiceModuleImpl implements validationServiceModule {

	private String result;
	@Override
	public String validateServiceModule(String iconname, String title, String description) {
	
		
		try {
			int iconlen=iconname.length();
			int titlelen=title.length();
			int desclen=description.length();
			
			if(iconlen<4 || iconlen>30)
			{
				result="INVALID ICON NAME";
			}
			else if(titlelen<4 || titlelen>18)
			{
				result="INVALID TITLE";
			}
			else if(desclen<50 || desclen>75 )
			{
				result="INVALID DESCRIPTION NAME";
			}
			else
			{
				result="VALID";
			}
				
		}
		catch(Exception e)
		{
			result="SOMETHING WENT WRONG in validation";
			e.printStackTrace();
		}
		return result;
	}

}
