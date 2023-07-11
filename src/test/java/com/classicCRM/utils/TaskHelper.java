package com.classicCRM.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TaskHelper {
	
	
	

	
	//take screenshot method
	
	public void getScreenshot(String name,WebDriver driver) throws IOException {
		//path D:\SeleniumWorkspace\ClassicCRMBDD\Screenshots
		File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\screenshots\\"+name+".jpg"));
		System.out.println("screenshot taken");
	}

}
