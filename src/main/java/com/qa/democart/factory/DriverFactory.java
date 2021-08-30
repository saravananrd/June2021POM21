package com.qa.democart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static String highlight;
	//private OptionManager optionManager;
	public static ThreadLocal<WebDriver> tlDriver  = new ThreadLocal<WebDriver>();
	
	
	//Method is used to initilize driver
	
	public WebDriver initDriver(Properties prop) {
		
		String browserName =prop.getProperty("browser");
		  highlight =prop.getProperty("highlight");
		
		System.out.println("browser name is:" + browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			 
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		
		getDriver().get(prop.getProperty("url"));
		return getDriver();
		
				
	}
	
	public WebDriver getDriver() {
		
		return tlDriver.get();
	}
	// Initilaize the properities on the basis of given env names
	
	public Properties initProperties() {
		Properties prop = null;
		
	try {
		FileInputStream ip = new FileInputStream("./src/test/resources/ConfiProperties");
		prop = new Properties();
		prop.load(ip);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
			
		return prop;
	}
	return prop;
	

}
	
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);		
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}

