package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;

public class SignIn extends BasePage{
	WebDriver driver;
	 ElementUtil eutil;
	
	
	//Locators
	By logo=By.xpath("/html/body/div/div/div[2]");
	By SignUp=By.linkText("Sign up");
	By username=By.id("username");
	By password=By.id("password");
	By LoginButton=By.id("loginBtn");
	
			
	
	
	
	public SignIn(WebDriver driver) {
		this.driver=driver;
		eutil=new ElementUtil(driver);

	}
	
	
	//Page actions
	/**
	 * 
	 * @return result (Boolean value)
	 */
	public boolean logo() {
return eutil.IsElementDisplayed(logo);
}
	
/**
 * 
 * @return Boolean value
 */
	public Boolean SignUp_displayed() {
		//return (driver.findElement(SignUp).isDisplayed());
		return eutil.IsElementDisplayed(SignUp);	}
	
	
	public HomePage doLogin(String uname,String pwd) {
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(LoginButton).click();
		return new HomePage(driver);
		}
	
	
}
	