package com.classicCRM.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css=".btn.btn-small")
	WebElement login_btn;
	
	
	//initializing elements
	
	 public LoginPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver	, this);
		
		
	}
	
	
	public void enterLoginDetails(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", login_btn);
		
		
	}
	
	
	

}
