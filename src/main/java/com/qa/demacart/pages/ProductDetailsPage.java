package com.qa.demacart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.ElementUtil;

public class ProductDetailsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productHeader = By.cssSelector("div#content h1"); 
	private By ImageThumb = By.cssSelector("ul.thumnails img");
	private By productData =By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By prodcutPrice = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addtoCatBtn = By.id("button-cart");
	
	private Map<String, String> productInfoMap;

	public ProductDetailsPage(WebDriver driver) {
		this.driver= driver; 		
		eleUtil = new ElementUtil(driver);
	}
	
	public String getProductHeaderText() {
		return eleUtil.doGetText(productHeader); 
	}
	
	public int productImgCount() {
		return eleUtil.getElements(ImageThumb).size();
	}
	
	public Map<String, String> getProductInfo() {
		productInfoMap = new HashMap<String, String>();
		productInfoMap.put("name", getProductHeaderText());
		
		List<WebElement> metaData = eleUtil.getElements(productData);
		System.out.println("total product meta data list:" + metaData.size());
		
		
		//metedata
		for(WebElement e: metaData) {
			String meta[]= e.getText().split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey,metaValue);
		}
		
		//price 
		List<WebElement> priceList = eleUtil.getElements(prodcutPrice);
		System.out.println("total product price meta data list:" + priceList.size());
		String pricel =priceList.get(0).getText().trim();		
		System.out.println("total product meta data list:" + pricel);
		String externalPrice =priceList.get(1).getText().trim();
		System.out.println("total product meta data list:" + externalPrice);
		productInfoMap.put("price",pricel);
		productInfoMap.put("Exrice",externalPrice);
		
		return productInfoMap;
		
			
		
		
	}

}
