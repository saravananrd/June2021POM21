package com.qa.democart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.demacart.pages.AccountPage;
import com.qa.democart.utils.AppErrors;
import com.qa.democart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends BaseTest {
	
	@Epic("QF-9867: Login page for open cart application***") // not connect to Jira jus message
	@Story("QF-5688: Login page feature****") 
	@Description("Login page title test *****") // Allure Report
	@Severity(SeverityLevel.BLOCKER) //Allure Report
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String Ptitle=loginPage.pageTitle();
		System.out.println("lp title:"+ Ptitle);
		Assert.assertEquals(Ptitle,Constants.Login_PAGE_TITLE, AppErrors.TITLE_ERROR_MESSAGE);		
		
	}
	@Description("Login page header test *****")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void loginPageHeaderTest() {
		String loginHeader = loginPage.YourStore();
		System.out.println("Login Page Header:" + loginHeader);
		Assert.assertEquals(loginHeader,Constants.Login_PAGE_HEADER, AppErrors.HEADER_ERROR_MESSAGE);	 
		
	}
	@Description("forget password link test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void ForgotPassworLinkTest() {
		Assert.assertTrue(loginPage.forPwdLink());		
	}
	@Description("Login page test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority =4) 
	public void doLoginTest() {
		AccountPage accPage =loginPage.login(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accPage.isLogoutLinkExisit());
		
	}	

	
	
}
