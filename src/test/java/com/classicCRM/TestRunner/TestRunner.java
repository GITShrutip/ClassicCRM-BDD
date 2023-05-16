package com.classicCRM.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/com/classicCRM/Features",
		glue="/com/classicCRM/StepDef",
		
		monochrome=true,
		
		plugin="html:reports/classicCRMReport.html"
		
		)


	


public class TestRunner extends  AbstractTestNGCucumberTests{

}
