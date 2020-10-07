package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.utils.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	

	public WebDriver init_driver(Properties prop) {
		String browser=prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}

		else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			
		}

		else {
			System.out.println("Please select correct browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
		
	}

	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Personal\\JavaFullCode\\POM_9_Sep\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return prop;
	}

}
