package com.classicCRM.PageObjects;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMMenuBar {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public CRMMenuBar(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	//global wait
	
	
	
	//company Menu
	
	
	By companiesMainMenu=By.cssSelector("a[title=\"Companies\"]");
	By newCompany=By.cssSelector("a[title=\"New Company\"]");  
	By combinedForm=By.cssSelector("a[title=\"Combined Form\"]"); //a[title="New Company"]
	By fullSearchForm=By.cssSelector("a[title=\"Full Search Form\"]");
	//Combined Form
	//Full Search Form
	
	
	
	
	public void selectNewCompany() {
		action=new Actions(driver);
		driver.switchTo().frame("mainpanel");
		action.moveToElement(driver.findElement(companiesMainMenu)).build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(newCompany)));
		driver.findElement(newCompany).click();	
	}
	
	
	

}
