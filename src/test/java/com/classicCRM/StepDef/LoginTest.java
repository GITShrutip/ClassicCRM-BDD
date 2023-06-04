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
import com.classicCRM.utils.Container;

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
	Container contextClass;

	public LoginTest(Container contextClass) {
		this.contextClass = contextClass;
		prop = contextClass.prop;

	}

	@Given("I have verified its title")
	public void i_have_verified_its_title_free_crm_crm_software_for_customer_relationship_management_sales_and_support() {

		// title should be - #Free CRM - CRM software for customer relationship
		// management, sales, and support.

		System.out.println(
				"i_have_verified_its_title_free_crm_crm_software_for_customer_relationship_management_sales_and_support");
		Assert.assertEquals(prop.getProperty("title").split(" ")[2], contextClass.driver.getTitle().split(" ")[2]);
	}

	@When("I enter valid Email ID and Password")
	public void i_enter_valid_email_id_and_password() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("i_enter_valid_email_id");
		contextClass.pageObjectManager.getLoginPage().enterLoginDetails(prop.getProperty("uname"),
				prop.getProperty("password"));
		// contextClass.loginPage.enterLoginDetails(prop.getProperty("uname"),
		// prop.getProperty("password"));
	}

	@Then("I logged into crm")
	public void i_logged_into_crm_crmpro_title() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("i_logged_into_crm_crmpro_title");
		Assert.assertEquals("CRMPRO", contextClass.driver.getTitle());
	}

	@Given("I am on Classic CRM Page")
	public void i_am_on_classic_crm_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("i_am_on_classic_crm_page");
		contextClass.baseclass.gotoURL(contextClass.driver);
		contextClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("^I enter (.+) in username and password (.+)$")
	public void i_enter_name2_in_username(String uname, String pwd) {

		System.out.println("enter uname " + uname);
		contextClass.pageObjectManager.getLoginPage().enterLoginDetails(uname, pwd);
	}

	@When("click on login button")
	public void click_on_login_button() {
		System.out.println("click_on_login_button");
		contextClass.pageObjectManager.getLoginPage().clickOnLogin();
	}

	@Then("I should not redirect to any page")
	public void i_should_not_redirect_to_any_page_verify_title_again() {
		System.out.println("i_should_not_redirect_to_any_page_verify_title_again");
		Assert.assertEquals(prop.getProperty("title").split(" ")[2], contextClass.driver.getTitle().split(" ")[2]);

	}

}
