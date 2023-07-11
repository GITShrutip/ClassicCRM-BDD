package com.classicCRM.StepDef;

import java.io.IOException;
import java.time.Duration;


import com.classicCRM.utils.Container;
import com.classicCRM.utils.GeneralUtility;

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
		contextClass.driver.quit();
	}

}
