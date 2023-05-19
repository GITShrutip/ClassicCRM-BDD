package com.classicCRM.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;

public class ClassicCRMBase {
	
	protected WebDriver driver;
	protected Properties prop;
	
	
	
	public WebDriver getDriver() throws FileNotFoundException, IOException {
		prop=initializeProperty();
		if(prop.getProperty("browser").equals("chrome")) {
			driver=new ChromeDriver();
			}
		return driver;
	}
	
	public void gotoURL(WebDriver driver) {
		driver.get(prop.getProperty("url"));	
	}
	
	public Properties initializeProperty() throws FileNotFoundException, IOException {
		prop=new Properties();
		prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\classicCRM\\Resources\\global.property")));
		
		return prop;
	}
	
	
	

}
