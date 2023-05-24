package com.classicCRM.PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classicCRM.utils.ExcelUtilities;

public class NewCompanyPage {

	WebDriver driver;
	WebDriverWait wait;

	public NewCompanyPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Fields in Company form
	// in frame 1

	By companyName = By.id("company_name");
	By industryName = By.name("industry");
	By status = By.cssSelector("select[name=\"status\"]"); // this is dropdown
	By category = By.cssSelector("select[name=\"category\"]"); // this is dropdown
	By priority = By.cssSelector("select[name=\"priority\"]"); // this is dropdown

	// Address section
	By addressTitle = By.cssSelector("input[name='address_title']");
	By address = By.cssSelector("textarea[name='address']");
	By city = By.cssSelector("input[name='city']");

	By tags = By.id("tags");

	By submitBtn = By.xpath("//form[@id='companyForm']//td[@align='center']/input");

	public String getTitle() {
		return driver.getTitle();
	}

	public void fillDataFromExcel(String excelName) throws IOException {

		List<HashMap<String, String>> excelData = ExcelUtilities.getExcelData_HashMap(excelName);

		Iterator<HashMap<String, String>> it = excelData.iterator();

		// now fill data into form
		Select select;
		HashMap map;

		// switching driver to frame
		//driver.switchTo().frame("mainpanel");

		map = it.next();

		driver.findElement(companyName).sendKeys(map.get("Company") + "");
		driver.findElement(industryName).sendKeys(map.get("Industry") + "");
		// handing dropdown
		select = new Select(driver.findElement(status));
		select.selectByValue(map.get("Status") + "");
		select = new Select(driver.findElement(category));
		select.selectByValue(map.get("Category") + "");
		select = new Select(driver.findElement(priority));
		select.selectByValue(map.get("Priority") + "");

		driver.findElement(addressTitle).sendKeys(map.get("AddressTitle") + "");
		driver.findElement(address).sendKeys(map.get("Address") + "");
		driver.findElement(city).sendKeys(map.get("City") + "");
		driver.findElement(tags).sendKeys(map.get("Tags") + "");

		System.out.println("data fill up done");
		

	}
	
	public boolean clickOnSaveBtn() {
		driver.findElement(submitBtn).click();
		return true;
	}

}
