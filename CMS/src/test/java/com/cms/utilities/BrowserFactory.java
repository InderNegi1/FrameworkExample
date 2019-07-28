package com.cms.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	
	public static WebDriver startApplication(WebDriver driver,String BrowserName,String AppURL)
	{
		if(BrowserName.equals("Chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	        driver = new ChromeDriver();
	        
		}
		else if(BrowserName.equals("Mozila"))
		{
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	        driver = new FirefoxDriver();
		}
		else if(BrowserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./driver/MicrosoftWebDriver.exe");
	        driver = new InternetExplorerDriver();
		}
		else 
		{
			System.out.println("We do not support "+BrowserName+" browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(AppURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void QuitBrowser(WebDriver driver)
	{
		driver.quit();
		
	}

}
