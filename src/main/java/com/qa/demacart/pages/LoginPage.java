package com.qa.demacart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUti;
	
	
	
	private By email= By.id("input-email"); 
	private By password= By.id("input-password"); 
	private By loginBtn= By.xpath("//input[@value='Login']"); 
	private By forgotPwdLink= By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']"); 
	private By StoreImg = By.cssSelector("div#logo h1 a");
	private By registerLink = By.linkText("Register");


//Constructor
public  LoginPage(WebDriver driver) {
	this.driver= driver;
	eleUti = new ElementUtil(driver);
	
	
}

//page actions /page methods functionality /behaviour of the page
@Step("getting login page title")
public String pageTitle() {
	//return driver.getTitle();	 
	return eleUti.waitForTitleIs(Constants.Login_PAGE_TITLE, 5);
}
@Step("getting header text") //Allure Report
public String YourStore() {
	//return driver.findElement(StoreImg).getText();
	return eleUti.doGetText(StoreImg);
}
@Step("forgot pwd link is displayed on login page") //Allure Report
public boolean forPwdLink() {
	// return driver.findElement(forgotPwdLink).isDisplayed();
	return eleUti.doIsDisplayed(forgotPwdLink);
}
@Step("login to applicaiton with username{0} and password{1}")
public AccountPage login(String un, String Pwd) {
	eleUti.doSendKeys(email, un);
	//driver.findElement(email).sendKeys(un);
	//driver.findElement(password).sendKeys(Pwd);
	eleUti.doSendKeys(password, Pwd);
	//driver.findElement(loginBtn).click();
	eleUti.doClick(loginBtn);
	return new AccountPage(driver);
	
}

@Step("Navigate to next page REgisterPage")
public RegistrationPage navigateToRegisterPage() {
	eleUti.doClick(registerLink);
	return new RegistrationPage(driver);
}
}

