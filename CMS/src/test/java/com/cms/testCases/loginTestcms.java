package com.cms.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cms.pages.LoginPage;
import com.cms.utilities.ExcelDataProvider;
import com.cms.utilities.Helper;

public class loginTestcms extends BaseClass {

	@Test(priority=1)
	public void loginApp() {
		
		logger= report.createTest("Login to cms");

		// System.out.println(driver.getTitle());
		LoginPage objLogin = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");

		objLogin.LoginTocms(objExcl.getStringData("login", 0, 0), objExcl.getStringData("login", 0, 1));
		
		logger.pass("Login Successfull");
		
	}
	
	@Test(priority=2)
	public void GetTitile() {
		
		logger= report.createTest("Getting Title of the Home page");

		System.out.println(driver.getTitle());
	
		logger.fail("Title does not match");
		
	}

}
