package com.cms.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties Pro;
	
	public ConfigDataProvider()
	{
		File src=new File("./Config/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			Pro=new Properties();
			
			Pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file "+e.getMessage());
			e.printStackTrace();
		} 
	}
	
	public String getDataFromConfig(String KeyToSearch)
	{
		return Pro.getProperty(KeyToSearch);
	}

	public String getBrowser()
	{
		return Pro.getProperty("Browser");
	}
	
	public String getURL() 
	{
		return Pro.getProperty("URL");
	}
}
