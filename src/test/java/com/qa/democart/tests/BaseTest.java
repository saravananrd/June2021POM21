package com.qa.democart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.demacart.pages.AccountPage;
import com.qa.demacart.pages.LoginPage;
import com.qa.demacart.pages.ProductDetailsPage;
import com.qa.demacart.pages.ResultsPage;
import com.qa.democart.factory.DriverFactory;
import com.qa.democart.utils.JavaScriptUtil;

public class BaseTest {
	WebDriver driver;
	Properties prop;
	DriverFactory df;
	
	LoginPage loginPage;
	AccountPage accountPage;
	ResultsPage resultPage;
	ProductDetailsPage producdetailspage;
	
	 
	
	
	
	@BeforeTest
	public void setUp() {
	
		df= new DriverFactory();
		prop=df.initProperties();
		driver= df.initDriver(prop);
		loginPage = new LoginPage(driver);
		
		
		
	}
	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}
