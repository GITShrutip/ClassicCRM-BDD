package com.classicCRM.StepDef;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;

import com.classicCRM.PageObjects.CompanyHomePage;
import com.classicCRM.utils.Container;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompanyHomePageStepDef {

	Container contextClass;
	Properties prop;
	CompanyHomePage companyHomePage;

	public CompanyHomePageStepDef(Container contextClass) {
		this.contextClass = contextClass;
		prop = contextClass.prop;
		companyHomePage = contextClass.pageObjectManager.getCompanyHomePage();
	}

	@When("I am on filter page for company")
	public void i_am_on_filter_page_for_company() {
		Assert.assertTrue(companyHomePage.verifyForAdvanceSearchTab());

	}

	//I apply Valid filter for <status>,<Category> and <Name>
	 @And("^I apply Valid filter for (.+),(.+)and(.+)$")
	public void i_apply_valid_filter_for_status_client_and_new_company_ide(String status,String category, String company) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", status);
		map.put("category", category);
		map.put("company", company);
		companyHomePage.fillDataInAdvanceSearch(map);
	}

	@When("I click on Search")
	public void i_click_on_search() {
		// Write code here that turns the phrase above into concrete actions
		companyHomePage.clickOnSubmit();
	}

	@Then("I should get results matching to my filter")
	public void i_should_get_results_matching_to_my_filter() {
		Assert.assertTrue(companyHomePage.checkifSearchResultDisplayed());
	}

	@Then("^search result should contain (.+)$")
	public void search_result_should_contain_new_company_ide(String companyName) {
		
		Assert.assertTrue(companyHomePage.isDataPresentInResultTable(companyName));
		
	}

}
