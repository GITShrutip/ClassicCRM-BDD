package com.classicCRM.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMContactPage {
	WebDriver driver;

	CRMContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[title='Contacts']")
	WebElement contactlink;

	@FindBy(css = "a[title='New Contact']")
	WebElement newContactLink;

	@FindBy(css = "form#contactForm")
	WebElement contactForm;

	public boolean isOptionAvailable() {

		driver.switchTo().frame("mainpanel"); // this is imp
		System.out.println("switch to frame");
		boolean flag;
		if (contactlink.isEnabled()) {
			flag = true;
		} else
			flag = false;

		System.out.println("Check option available PASS. Switch to frame");
		return flag;

	}

	public boolean clickOnNewContact() {
		Actions a = new Actions(driver);
		a.moveToElement(contactlink).build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //wait till DL appears
		wait.until(ExpectedConditions.visibilityOf(newContactLink));

		a.moveToElement(newContactLink).build().perform();
		newContactLink.click();

		System.out.println("checked and clicked on new contact link");
		return true;
	}

	public boolean isContactFormAvailable() {
		boolean flag;
		if (contactForm.isDisplayed()) {
			flag = true;
		} else
			flag = false;

		return flag;

	}

}
