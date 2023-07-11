package com.classicCRM.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GeneralUtility {
	
	public static void getSpcreenshot(String name,WebDriver driver) throws IOException {
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\Screenshots\\"+name+".jpg"));
	}

}
