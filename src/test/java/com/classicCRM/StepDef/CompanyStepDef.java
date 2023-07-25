package com.classicCRM.StepDef;

import java.io.IOException;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.classicCRM.PageObjects.NewCompanyPage;
import com.classicCRM.utils.Container;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompanyStepDef {
	Container contextClass;
	NewCompanyPage newCompany;
	
	public CompanyStepDef(Container contextClass) throws IOException {
		this.contextClass=contextClass;
		newCompany=contextClass.pageObjectManager.getNewCompanyPage();
		
	}
	
	
	@When("I complete filling data form from excel data")
	public void i_complete_filling_data_form_from_excel_data() throws IOException {
	    System.out.println("i_complete_filling_data_form_from_excel_data");
	    newCompany.fillDataFromExcel("NewCompanyData");	    
	    
	}
	@Then("I click on save button")
	public void i_click_on_save_button() {
	   System.out.println("i_click_on_save_button");
	   Assert.assertTrue(newCompany.clickOnSaveBtn());
	}
	@Then("then data should get saved successfully")
	public void then_data_should_get_saved_successfully() {
	    System.out.println("then_data_should_get_saved_successfully");
	    //assert for the redirected page
	}

}
