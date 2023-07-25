package com.classicCRM.StepDef;

import org.junit.Assert;

import com.classicCRM.PageObjects.CRMContactPage;
import com.classicCRM.utils.Container;
import com.classicCRM.utils.GeneralUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactPageStepDef {
	private Container contextClass;
	CRMContactPage contactPage;

	public ContactPageStepDef(Container contextClass) {
		this.contextClass = contextClass;
		contactPage = contextClass.pageObjectManager.getContactPage();
	}

	@Given("check contact option is available in menu bar")
	public void check_contact_option_is_available_in_menu_bar() {

		System.out.println("Executing ::check contact option is available in menu bar ");
		Assert.assertTrue(contactPage.isOptionAvailable());

	}

	@When("I click on add new contact option")
	public void i_click_on_add_new_contact_option() {
		System.out.println("Executing ::I click on add new contact option");
		Assert.assertTrue(contactPage.clickOnNewContact());
	}

	@Then("I validate whether contact form is available")
	public void i_validate_whether_contact_form_is_available() {
		System.out.println("Executing ::I validate whether contact form is available");
		Assert.assertTrue(contactPage.isContactFormAvailable());
	}

}
