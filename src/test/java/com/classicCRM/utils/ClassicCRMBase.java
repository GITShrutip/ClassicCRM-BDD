package com.classicCRM.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import io.cucumber.java.After;

public class ClassicCRMBase {
	
	protected  WebDriver driver;
	protected Properties prop;
	
	//for reporting 
	
	
	
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
	
	public   void getScreenshot(String name) throws IOException {
		//path D:\SeleniumWorkspace\ClassicCRMBDD\Screenshots
		File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\screenshots\\"+name+".jpg"));
		System.out.println("screenshot taken");
	}
	

}
