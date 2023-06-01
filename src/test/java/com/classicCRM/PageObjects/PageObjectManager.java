package com.classicCRM.PageObjects;

import java.awt.Menu;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	WebDriver driver;
	LoginPage loginPage;
	CRMHomePage homePage;
	CRMMenuBar menuBar;
	NewCompanyPage newCompanyPage;
	CompanyHomePage companyHomePage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		// check if page object is created
		loginPage = loginPage == null ? new LoginPage(driver) : loginPage;
		return loginPage;
	}

	public CRMHomePage getHomePage() {

		homePage = homePage == null ? new CRMHomePage(driver) : homePage;
		return homePage;
	}
	
	public CRMMenuBar getMenuBar() {
	
		menuBar=menuBar==null? new CRMMenuBar(driver) : menuBar;
		return menuBar;
	}
	
	public NewCompanyPage getNewCompanyPage() {
		newCompanyPage= newCompanyPage==null? new NewCompanyPage(driver) : newCompanyPage;
		return newCompanyPage;
	}
	
	public CompanyHomePage getCompanyHomePage() {
		companyHomePage = companyHomePage==null ? new CompanyHomePage(driver):companyHomePage;
		return companyHomePage;
	}

}
