package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {
	
	WebDriver driver;
	 ElementUtil elementutil;
	
	
	//Locators
	By header=By.xpath("//h1");
	By accountName=By.xpath("//span[@class=\"account-name \"]");
	
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}

	
	public String verifyPageTitle() {
		//return driver.getTitle();
		return elementutil.get_Title();
	}
	
	
	public String verifyPageHeader() {
		if(driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
		}
		return null;
	}
	
	
	
	public String verifyAccountName() {
		return driver.findElement(accountName).getText();
	}
	

}
