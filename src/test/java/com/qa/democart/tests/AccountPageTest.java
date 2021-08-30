package com.qa.democart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetup() {
		accountPage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Epic("QF-5678: Login page for open cart application***") // not connect to Jira jus message
	@Story("QF-1234: Login page feature****") 
	@Description("Login page title test *****") // Allure Report
	@Severity(SeverityLevel.BLOCKER) //Allure Report
	@Test(priority = 1)
	public void accPageTitleTest() {
		String accTitle = accountPage.AccPageTitle();
		System.out.println("Accout page Title:" +accTitle);
		Assert.assertEquals(accTitle,Constants.Acccount_PAGE_TITLE);
	}
	
	
	@Test(priority = 2)
	public void accPageHeaderTest() {
		String accheader = accountPage.getAccPageHeader();
		System.out.println("Accout page h:" +accheader);
		Assert.assertEquals(accheader,Constants.Login_PAGE_HEADER);
	}
	
	
	@Test(priority = 2)
	public void accSectionListTest() {
		List<String> accList =accountPage.getAccHeader();
		System.out.println("Accout List" + accList);
		Assert.assertEquals(accList, Constants.EXPECTED_ACCOUNT_LIST);
		
		
	}
	@Test(priority = 4)
	public void LogoutLinkExistTest() {
		Assert.assertTrue(accountPage.isLogoutLinkExisit());
	}
	
	
	@DataProvider 
	public Object[][] getSearchData() {
		return new Object[][] {{"Macbook Pro"},
			{"Macbook Air"}, 
			{"Apple"}};
	}
	
	@Test(priority = 5, dataProvider = "getSearchData")
	public void searchTest(String ProductName) {
		resultPage =accountPage.doSearch(ProductName);
		String resultHeader =resultPage.getSearchPageHeader();
		System.out.println("result header is:" + resultHeader);
		Assert.assertTrue(resultHeader.contains(ProductName));		
	}
	
	
	
//	@DataProvider 
//	public Object[][] getProductSelectData() {
//		return new Object[][] {
//			{"Macbook","MacBook Air"},
//			{"Macbook","MacBook Pro"},
//			{"Apple","Apple Cinema 30\""},
//		};
//	}
	
	
	@DataProvider 
	public Object[][] getProductSelectData() {
		return ExcelUtil.getTestData(Constants.Product_Name);
	}
	
	
	@Test(priority =6,dataProvider = "getProductSelectData")
	public void selectProductTest(String mainSearch, String resultSearch) {
		resultPage =accountPage.doSearch(mainSearch);
		producdetailspage =resultPage.selectProductResults(resultSearch);	
//		String header = producdetailspage.getProductHeaderText();
//		System.out.println("product details page:" + header);
//		Assert.assertEquals(header, resultSearch);
		
	}
	
	


}
