package com.qa.democart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

public class OptionManager {
	
	private Properties prop;
	private ChromeOptions co;
	
	public OptionManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co=new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim()))  
			co.addArguments("--headless");			
		 
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) 
			co.addArguments("--incognito");		
		return co;
			}

}
