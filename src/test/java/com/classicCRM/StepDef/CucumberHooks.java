package com.classicCRM.StepDef;

import java.time.Duration;

import com.classicCRM.utils.Container;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
	Container contextClass;
	public CucumberHooks(Container contextClass) {
		this.contextClass=contextClass;
	}
	@Before
	public void beforeSetup() {
		contextClass.driver.manage().window().maximize();
		contextClass.driver.manage().deleteAllCookies();
		contextClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@After
	public void quitdriver() {
		contextClass.driver.quit();
	}

}
