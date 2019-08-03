package com.cms.testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cms.utilities.BrowserFactory;
import com.cms.utilities.ConfigDataProvider;
import com.cms.utilities.ExcelDataProvider;
import com.cms.utilities.Helper;

public class BaseClass {
	WebDriver driver;
	ExcelDataProvider objExcl;
	ConfigDataProvider objConfig;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up reports and test getting started.",true);
		objExcl=new ExcelDataProvider();
		objConfig=new ConfigDataProvider();
		//ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/CMS_"+Helper.getCurrentDateTime()+".html")); 
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/CMSreport.html")); 
		report=new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting done test can be started.",true);
	}
	
	@Parameters({"browser","URLtoBeTest"})
	@BeforeClass
	public void setup(String exBrowser, String URL)
	{
		Reporter.log("Trying to start browser and getting application ready",true);
		
		//driver=BrowserFactory.startApplication(driver, objConfig.getBrowser(), objConfig.getURL());
		
		driver=BrowserFactory.startApplication(driver, exBrowser, URL);
		Reporter.log("Browser and application is up and running.",true);
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.QuitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to End",true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.CaptureScreenShot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
	 	}
		report.flush();
		Reporter.log("Test Completed >>> Reports Generated..",true);
	}
}
