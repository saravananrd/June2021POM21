package com.qa.demacart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class AccountPage {
	
	private WebDriver driver;
	private ElementUtil eleUti;
	
	private By accSelections = By.cssSelector("div#content h2");
	private By header = By.cssSelector("div#logo > h1 > a");	 
	private By logoutLink= By.linkText("Logout");
	private By searchField = By.name("search");
	private By searchBtn = By.cssSelector("div#search button");
	
	

	

	public  AccountPage(WebDriver driver) {
		this.driver=driver;
		eleUti = new ElementUtil(driver);	
		
	}
	
	

	public String AccPageTitle() {
		return eleUti.waitForTitleContains(Constants.Acccount_PAGE_TITLE, 5);
	}
	
	public String AccPageUrl() {
		return eleUti.waitForUrlContains(Constants.Acccount_PAGE_TITLE_URL_FRACTION, 5);
	}
	
	public String getAccPageHeader() {
		return eleUti.doGetText(header);
	}
	
	
	public List<String> getAccHeader() {
		List<String> accSecValueList = new ArrayList<String>();
		List<WebElement> accSecList= eleUti.getElements(accSelections);
		for(WebElement e: accSecList) {
			accSecValueList.add(e.getText());
		}
		//Collections.sort(accSecValuist);
		return accSecValueList;
	}
	
	public boolean  isLogoutLinkExisit() {
		return eleUti.doIsDisplayed(logoutLink);
	}
	
	public ResultsPage doSearch(String ProducName)
{		 	System.out.println("Search the product" + ProducName);
			eleUti.doSendKeys(searchField, ProducName);
			eleUti.doClick(searchBtn);
			return new ResultsPage(driver);
		}
}
