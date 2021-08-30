package com.qa.democart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.demacart.pages.RegistrationPage;
import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {
	
	private RegistrationPage regpage;
	
	@BeforeClass
	public void regSetup() {
		regpage = loginPage.navigateToRegisterPage();
	}
	
	
	@Test
	public String getRadomNumber() {
		Random randon = new Random();
		String emailid ="testautomation"+randon.nextInt(5000)+"@gmail.com";
		System.out.println(emailid);
		return emailid;
		
		
	}
//	@DataProvider
//	public Object[][] RegTestValues() {
//		return new Object[][] {
//				{"tommy05", "rich05", "1234567", "ptest1234", "yes"},
//				{"tommy06", "rich06", "12345678", "ptest1235", "no"},
//				{"tommy07", "rich07", "12345679", "ptest1236", "yes"}
//	};
			
//			}
	
	@DataProvider
   public Object[][] RegTestValues() {
		return ExcelUtil.getTestData(Constants.Sheet_Name);
		
	}
	
	@Test(dataProvider="RegTestValues")
	public void registrationTest(String firstName,String lasttName,String telephone,
								String password,String subscr) {
		Assert.assertTrue(regpage.accRegistration(firstName,lasttName,
				getRadomNumber(),telephone,telephone,subscr));
		 
	
	}
}
