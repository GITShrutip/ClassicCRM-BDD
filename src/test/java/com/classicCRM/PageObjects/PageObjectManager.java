package com.classicCRM.PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	WebDriver driver;
	LoginPage loginPage;
	CRMHomePage homePage;

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

}
