package com.classicCRM.PageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyHomePage {

	WebDriver driver;
	WebDriverWait wait;
	Select select;

	public CompanyHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialize elements

	}

	// Filter Elements Cacheup elements and use findBy to initialize

	@FindBy(name = "cs_status")
	@CacheLookup
	WebElement status;

	@FindBy(name = "cs_category")
	@CacheLookup
	WebElement category;

	@FindBy(name = "cs_name")
	@CacheLookup
	WebElement companyName;

	@FindBy(xpath = "//*[@name='cs_submit' and @Value='Search']")
	WebElement submitBtn;

	@FindBy(xpath = "//*[@id='btn_cs_search']/parent::td")
	WebElement advanceSearchTab;
	// btn_cs_search
	
	@FindBy(css="#vCompaniesForm  tr:nth-Child(5)") //#vCompaniesForm  tr:nth-child(5)
	WebElement tableContent;
	
	////*[@id="vCompaniesForm"]//td[2]/a[@context='company']
	@FindBy(xpath="//*[@id='vCompaniesForm']//td[2]/a[@context='company']")
	List<WebElement> getCompanyNames;
	

	// implement methods

	public void fillDataInAdvanceSearch(Map<String, String> map) {

		status.sendKeys(map.get("status"));

		category.sendKeys(map.get("category"));

		companyName.sendKeys(map.get("company"));

	}

	public boolean clickOnSubmit() {

		submitBtn.click();

		return true;
	}

	//function to check whether advance search tab is displayed
	public boolean verifyForAdvanceSearchTab() {
		boolean flag = false;
		System.out.println(advanceSearchTab.getText()+"This is text");
		if (advanceSearchTab.isDisplayed()) {
			flag = advanceSearchTab.getText().trim().contains("Advanced");
			return flag;
		}
		return flag;

	}

	public boolean checkifSearchResultDisplayed() {
		
		return tableContent.isDisplayed();
		
		
	}
	
	
	public boolean isDataPresentInResultTable(String cName) {
		System.out.println(getCompanyNames.stream().anyMatch(x->x.getText().contains(cName)) + cName);
		getCompanyNames.forEach(x->x.getText());
		
		return (getCompanyNames.stream().anyMatch(x->x.getText().contains(cName.trim())));
		
	}

}
