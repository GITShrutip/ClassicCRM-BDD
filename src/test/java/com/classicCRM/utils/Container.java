package com.classicCRM.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.classicCRM.PageObjects.CRMHomePage;
import com.classicCRM.PageObjects.LoginPage;
import com.classicCRM.PageObjects.PageObjectManager;

public class Container {
	
	public WebDriver driver;
	
	public ClassicCRMBase baseclass;
	public Properties prop;
	public PageObjectManager pageObjectManager;
	
	public Container() throws FileNotFoundException, IOException {
		baseclass=new ClassicCRMBase();
		driver=baseclass.getDriver();
		prop=baseclass.initializeProperty();
		pageObjectManager=new PageObjectManager(driver);
	}
	
		

}
