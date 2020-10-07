package com.qa.hubspot.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	
WebDriver driver;
	
	public ElementUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement getElement(By locator) {
		WebElement element=driver.findElement(locator);
		return element;
	}
	
	public String get_Title() {
		
		return driver.getTitle();
	}
	
	
	public void do_sendkeys(By locator,String text) {
		getElement(locator).sendKeys(text);
}
	
	
	public void do_click(By locator) {
		getElement(locator).click();
	}
	
	
	public void do_clear(By locator) {
		getElement(locator).clear();
	}
	
	public void Do_dropdownSelection(By locator,Select obj_Select,int i) {
		obj_Select.selectByIndex(i);
			
	}
	
	public boolean IsElementDisplayed(By locator) {
		Boolean result=driver.findElement(locator).isDisplayed();
		return result;
	}
	
	public String waitfortitlePresent(String titleValue,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}




}
