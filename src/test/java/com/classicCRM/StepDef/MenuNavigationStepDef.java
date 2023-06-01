package com.classicCRM.StepDef;

import java.sql.Driver;
import java.util.Properties;

import com.classicCRM.PageObjects.CRMMenuBar;
import com.classicCRM.PageObjects.LoginPage;
import com.classicCRM.utils.Container;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class MenuNavigationStepDef {
	Container contextClass;
	Properties prop;
	LoginPage loginPage;
	CRMMenuBar menubar;
	
	public  MenuNavigationStepDef(Container contextClass) {
		this.contextClass=contextClass;
		this.prop=contextClass.prop;
	}

	@Given("Login to CRM Page")
	public void login_to_crm_page() {
		contextClass.baseclass.gotoURL(contextClass.driver);
	    loginPage=contextClass.pageObjectManager.getLoginPage();
	    loginPage.enterLoginDetails(prop.getProperty("uname"), prop.getProperty("password"));
	    loginPage.clickOnLogin();
	}
	@And("Navigate to New Company Section")
	public void navigate_to_new_company_section() {
	    
	menubar=contextClass.pageObjectManager.getMenuBar();
	menubar.selectNewCompany();
	
}

	@Given("Navigate to Company Filter Section")
	public void navigate_to_filter() {
		//verify i am on filter page and advance filter is displayed
		login_to_crm_page();
		contextClass.driver.switchTo().frame("mainpanel");
	    contextClass.pageObjectManager.getMenuBar().navigateToSearchCompany();
	}
	
}

