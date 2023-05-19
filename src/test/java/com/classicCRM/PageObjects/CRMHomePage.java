package com.classicCRM.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMHomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CRMHomePage(WebDriver driver){
		this.driver=driver;
	}
	
	By userDetails=By.xpath("//td[@class='headertext' and @align='left']");
	
	String FrameName="mainpanel";
	
	
	public Boolean validateForUserDetails(String user) {
		driver.switchTo().frame(FrameName);
		System.out.println(driver.findElement(userDetails).getText());
		Boolean value=driver.findElement(userDetails).getText().contains(user);	
		return value;
	}

}
