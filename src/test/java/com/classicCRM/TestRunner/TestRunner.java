package com.classicCRM.TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/com/classicCRM/Features",
		glue="/com/classicCRM/StepDef",
		
		monochrome=true,
		tags="@ContactPage ",
		
		plugin={"html:reports/classicCRMReport.html"
			//	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" //for extent reporting
		}
		//dryRun=true
		
		
		)

public class TestRunner extends  AbstractTestNGCucumberTests{
	
	// adding code to run scripts in parallel mode
	@Override 
	@DataProvider(parallel=true)
    public Object[][] scenarios() {
       return super.scenarios();
    }
	

}
