package com.classicCRM.StepDef;

import org.testng.Assert;

import com.classicCRM.utils.Container;

import io.cucumber.java.en.Then;

public class HomePageStepDefination {
	Container contextClass;
	public HomePageStepDefination(Container contextClass) {
	this.contextClass=contextClass;	
	}
	
	
	@Then("check for login user")
	public void check_for_login_user_shruti_automation() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("check_for_login_user_shruti_automation");
	    
	    Assert.assertTrue(contextClass.pageObjectManager.getHomePage().validateForUserDetails(contextClass.prop.getProperty("validUser")));
	}

}
