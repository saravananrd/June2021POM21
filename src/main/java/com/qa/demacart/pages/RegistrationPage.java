package com.qa.demacart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class RegistrationPage {
	
	
	
	private WebDriver driver;
	private ElementUtil eleUti;
	
	
	By firstname = By.id("input-firstname");
    By lastname = By.id("input-lastname");
    By emailId = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By conpassword = By.id("input-confirm"); 
    
   
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
    
    private By agreeCheckBox=By.name("agree");
    
    private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
    private By succMessg=By.cssSelector("div#content h1");
    private By logoutLink = By.linkText("Logout");
    private By registerLink = By.linkText("Register");
   
    
    
	 
	public  RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUti = new ElementUtil(driver);
		
	}
	
	
	public boolean accRegistration(String firstName, 
								String lastName,
								String emailId, 
								String telephone,
								String password,
								String subsribe) {
		
		eleUti.doSendKeys(this.firstname, firstName);
		eleUti.doSendKeys(this.lastname, lastName);
		eleUti.doSendKeys(this.emailId, emailId);
		eleUti.doSendKeys(this.telephone, telephone);
		eleUti.doSendKeys(this.password, password);
		eleUti.doSendKeys(this.conpassword, password);
		
		if(subsribe.equalsIgnoreCase("Yes"))
		{
			eleUti.doClick(subscribeYes);			
		}else 
		{
			eleUti.doClick(subscribeNo);	
		}
		
		eleUti.doClick(agreeCheckBox);
		eleUti.doActionsClick(continueButton);
		String sucMsg=eleUti.waitForElementPresence(succMessg, Constants.DEFAULT_TIME_OUT).getText();
		System.out.println("Registration is sucessfull: " + sucMsg);
		 
		if (sucMsg.contains(Constants.CONFIRMATION_MESSAGE))
		{
			eleUti.doClick(logoutLink);
			eleUti.doClick(registerLink);
		return true;
		}else
		{
			return false;
		}
		
	}

}
