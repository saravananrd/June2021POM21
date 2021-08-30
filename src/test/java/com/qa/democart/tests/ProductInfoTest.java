package com.qa.democart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductInfoTest extends BaseTest{
	
	@BeforeClass
	public void ProductInfoPageSetup() {
		accountPage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	} 
	
	@Test
	public void productImageTest() {
		resultPage = accountPage.doSearch("IMac");
		producdetailspage = resultPage.selectProductResults("iMac");
		Assert.assertEquals(producdetailspage.productImgCount(),3);
	
	}
	
	@Test
	public void productInfoTest() {
		resultPage = accountPage.doSearch("Macbook");
		producdetailspage= resultPage.selectProductResults("MacBook Pro");
		Map<String, String> accProdInfMap= producdetailspage.getProductInfo();
		
		Assert.assertEquals(accProdInfMap.get("name"), "MacBook Pro");
		Assert.assertEquals(accProdInfMap.get("Brand"), "Apple");
		Assert.assertEquals(accProdInfMap.get("Product Code"), "Product 18");
		Assert.assertEquals(accProdInfMap.get("Price"), "$2,000.00");
		
 	}
	

}
