package com.qa.hubspot.pageTests;

import java.util.Properties;

import javax.swing.text.StyleConstants.CharacterConstants;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.SignIn;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BasePage {

	WebDriver driver;
	HomePage hp;
	BasePage basepageObj;
	Properties prop;
	SignIn si;

	@BeforeTest
	public void setup() {
		basepageObj = new BasePage();
		prop = basepageObj.init_properties();
		driver=	basepageObj.init_driver(prop);
		
		si=new SignIn(driver);
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		hp = si.doLogin(prop.getProperty("username"), prop.getProperty("password"));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	
	@Test(priority=1)
	public void verifyPageTitleTest() {
	String title=hp.verifyPageTitle();
	Assert.assertEquals(title,Constants.PAGE_TITLE,"Home Page title does not match");
	}
	
	@Test(priority=2)
	public void verifyPageHeaderTest() {
		String headerText=hp.verifyPageHeader();
		Assert.assertEquals(headerText,Constants.PAGE_HEADER);
	}
	
	
	@Test(priority=3)
	public void verifyAccountNameTest() {
		String account =hp.verifyAccountName();
		Assert.assertEquals(account, prop.getProperty("Account_Name").trim());
		
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
}
