package com.qa.demacart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.ElementUtil;

public class ResultsPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By serachHeader = By.cssSelector("div#content h1");
	private By productResults = By.cssSelector("div.caption a");
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;	
		elementUtil = new ElementUtil(driver);
		
	}
	
	public String getSearchPageHeader() {
		return elementUtil.doGetText(serachHeader);		
	}
	
	
	public int getproductresults() {
		return elementUtil.getElements(productResults).size();		
		
	}
	
	public ProductDetailsPage selectProductResults(String mainProductName) {
		List<WebElement> searchList = elementUtil.getElements(productResults);
		for(WebElement e: searchList) {
			if(e.getText().trim().equals(mainProductName)) {
				e.click();
				break;
			}
				
			
		}return new ProductDetailsPage(driver);
		
		
	}

}
