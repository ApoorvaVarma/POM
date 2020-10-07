package com.qa.hubspot.pageTests;



import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.SignIn;

public class SignInTest {
	
	Properties prop;
	WebDriver driver;
	BasePage bp;
	SignIn si;
	
	
	
	@BeforeTest
	public void setup()
	{
		bp=new BasePage();
		prop=bp.init_properties();
		driver=bp.init_driver(prop);
		si=new SignIn(driver);
	//	driver=	bp.init_driver(prop);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		}
	
	
	@Test (priority = 1)
	public void logoTest() {
System.out.println("Logo exist ? : " +""+ si.logo());
	//System.out.println(si.logo());
	}
	
	@Test(priority = 1)
	public void SignUp_displayedTest() {
		System.out.println("SignUp_displayed ? " +si.SignUp_displayed());
		
	}
	
	
	
	
	@AfterTest
	public void teardown() {
		System.out.println("Execution is complete");
	//	driver.quit();
	}
	
}
