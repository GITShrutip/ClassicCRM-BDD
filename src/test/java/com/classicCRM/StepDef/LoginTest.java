package com.classicCRM.StepDef;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.classicCRM.PageObjects.CRMHomePage;
import com.classicCRM.PageObjects.LoginPage;
import com.classicCRM.utils.ClassicCRMBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	
	LoginPage loginPage;
	CRMHomePage homePage;
	ClassicCRMBase classicCRM;
	WebDriver driver;
	Properties prop;
	//first test


	
	
	@Before
	public void getDriver() throws FileNotFoundException, IOException {
		classicCRM = new ClassicCRMBase();
		System.out.println("Before Executed");
		prop=classicCRM.initializeProperty();
	//	loginPage = new LoginPage();
				
	}
	
	@Given("I have verified its title")
	public void i_have_verified_its_title_free_crm_crm_software_for_customer_relationship_management_sales_and_support() {
	    // Write code here that turns the phrase above into concrete actions
	    //title should be - #Free CRM  - CRM software for customer relationship management, sales, and support.
		
		System.out.println("i_have_verified_its_title_free_crm_crm_software_for_customer_relationship_management_sales_and_support");
		Assert.assertEquals(prop.getProperty("title").split(" ")[2], driver.getTitle().split(" ")[2]);
	}
	@When("I enter valid Email ID and Password")
	public void i_enter_valid_email_id_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("i_enter_valid_email_id");
	    
	    loginPage.enterLoginDetails(prop.getProperty("uname"), prop.getProperty("password"));
	}


	@Then("I logged into crm")
	public void i_logged_into_crm_crmpro_title() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("i_logged_into_crm_crmpro_title");
	  
	   Assert.assertEquals("CRMPRO", driver.getTitle());
	   
	   
	}
	@Then("check for login user")
	public void check_for_login_user_shruti_automation() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("check_for_login_user_shruti_automation");
	    
	    Assert.assertTrue(homePage.validateForUserDetails(prop.getProperty("validUser")));
	}


@Given("I am on Classic CRM Page")
public void i_am_on_classic_crm_page() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("i_am_on_classic_crm_page");
    driver=classicCRM.launch();
    loginPage= new LoginPage(driver);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    
}
@When("^I enter (.+) in username and password (.+)$")
public void i_enter_name2_in_username(String uname,String pwd) {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("enter uname "+uname);
	
	loginPage.enterLoginDetails(uname, pwd);
}

@When("click on login button")
public void click_on_login_button() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("click_on_login_button");
	
	homePage= loginPage.clickOnLogin();
}
@Then("I should not redirect to any page")
public void i_should_not_redirect_to_any_page_verify_title_again() {
    // Write code here that turns the phrase above into concrete actions
System.out.println("i_should_not_redirect_to_any_page_verify_title_again");

Assert.assertEquals(prop.getProperty("title").split(" ")[2], driver.getTitle().split(" ")[2]);

}

@After
public void tearDown() {
	driver.quit();
}

}
