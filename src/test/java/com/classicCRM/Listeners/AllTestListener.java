package com.classicCRM.Listeners;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.classicCRM.utils.ClassicCRMBase;
import com.classicCRM.utils.Container;
import com.classicCRM.utils.TaskHelper;

public class AllTestListener extends TestListenerAdapter implements ITestListener {

//	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	TaskHelper helper;
	WebDriver driver;
	ExtentTest feature;
	ExtentTest scenario;

	public AllTestListener() {

		//htmlReporter = new ExtentHtmlReporter("extent.html");
		// initialize ExtentReports and attach the HtmlReporter
	//	extent = new ExtentReports();
	//	extent.attachReporter(htmlReporter);
		//htmlReporter.setAppendExisting(true);

	}

	@Override
	public void onTestStart(ITestResult result) {

		String methodName = result.getName();

		// create test and logging it in reporter
	//	test = extent.createTest("Test Execution Started .. Test Name :: " + methodName);
	//	test.log(Status.INFO, "Test Execution started for " + methodName);
		// assign author
	//	test.assignAuthor(System.getProperty("user.name"));

		try {
			// define feature and scenario for given test
			feature = extent.createTest(new GherkinKeyword("Feature"), result.getClass().toString());
			scenario = feature.createNode(new GherkinKeyword("Scenario"), methodName);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();

		try {
			// add to extent report
			scenario.createNode(new GherkinKeyword("Given"), "Jeff has bought a microwave for $100").pass("pass");
			scenario.createNode(new GherkinKeyword("And"), "he has a receipt").pass("pass");
			scenario.createNode(new GherkinKeyword("When"), "he returns the microwave").pass("pass");
			scenario.createNode(new GherkinKeyword("Then"), "Jeff should be refunded $100").pass("pass");

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		// logging
		//test.log(Status.PASS, "Test Execution Completed for " + methodName);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();

		// logging
		//test.log(Status.FAIL, "Test Execution Failed for " + methodName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	//	test.skip("Test got skipped " + result.getMethod().getMethodName());
	//	test.log(Status.SKIP, "Test Execution skipped for " + result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {

	//	test.log(Status.INFO, "Finishing test Execution. ");
		extent.flush();
	}

}
