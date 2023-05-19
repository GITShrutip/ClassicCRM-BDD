package com.classicCRM.StepDef;

import com.classicCRM.utils.Container;

import io.cucumber.java.After;

public class CucumberHooks {
	Container contextClass;
	public CucumberHooks(Container contextClass) {
		this.contextClass=contextClass;
	}
	@After
	public void quitdriver() {
		contextClass.driver.quit();
	}

}
