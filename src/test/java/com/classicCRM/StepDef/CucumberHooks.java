package com.classicCRM.StepDef;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.classicCRM.utils.Container;
import com.classicCRM.utils.GeneralUtility;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {
	Container contextClass;
	public CucumberHooks(Container contextClass) {
		this.contextClass=contextClass;
	}
	@Before
	public void beforeSetup(Scenario scenario) throws IOException {
		contextClass.driver.manage().window().maximize();
		contextClass.driver.manage().deleteAllCookies();
		contextClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//for extent reporting
	
		
		
	}
	@After
	public void quitdriver(Scenario scenario) {
		
//		 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//		    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//		    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
//		    Reporter.setSystemInfo("Selenium", "3.7.0");
//		    Reporter.setSystemInfo("Maven", "3.5.2");
//		    Reporter.setSystemInfo("Java Version", "1.8.0_151");
//		    
//		  
//				String screenshotName = scenario.getName().replaceAll(" ", "_");
//				try {
//					//This takes a screenshot from the driver at save it to the specified location
//					File sourcePath = ((TakesScreenshot)contextClass.driver).getScreenshotAs(OutputType.FILE);
//					
//					//Building up the destination path for the screenshot to save
//					//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
//					File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
//					
//					//Copy taken screenshot from source location to destination location
//					Files.copy(sourcePath, destinationPath);   
//
//					//This attach the specified screenshot to the test
//					Reporter.addScreenCaptureFromPath(destinationPath.toString());
//				} catch (IOException e) {
//				} 
//		    
//		    
//		    
		    
		    
		contextClass.driver.quit();
	}

}
