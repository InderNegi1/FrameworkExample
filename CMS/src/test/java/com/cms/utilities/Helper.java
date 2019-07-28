package com.cms.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//Screenshots, alerts, windows, frames, JavaScriptExecuter
	
	public static String CaptureScreenShot(WebDriver driver)
	{
		
		File src=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath= System.getProperty("user.dir")+"/Screenshots/_login_"+getCurrentDateTime()+".png";
		
		try {
			FileHandler.copy(src, new File (ScreenshotPath));
		} catch (Exception e) {
			System.out.println("Unable to capture screenshots.."+e.getMessage());
		}
		
		return ScreenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
		
		Date currentDate=new Date();
		
		return customFormat.format(currentDate);
	}

}
