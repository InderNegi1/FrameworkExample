package com.cms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="uid") WebElement txtUname;
	
	
	@FindBy(name="password") WebElement txtPassword;
	
	
	@FindBy(name="btnLogin") WebElement btnLogin;
	
	public void LoginTocms(String strName,String Password)
	{
		txtUname.sendKeys(strName);
		
		txtPassword.sendKeys(Password);
		
		btnLogin.click();
	}
	
	

}
