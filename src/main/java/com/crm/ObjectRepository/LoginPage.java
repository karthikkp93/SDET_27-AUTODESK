package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility  {

	// Create seperate class for web page
	
	
	// identify all the web elements and declare them as private
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//step 3 initialise the element using constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//step 4 utilization provide getter methods
	public WebElement getUsernameEdt() {
		return usernameEdt;
		}


	public WebElement getPasswordEdt() {
		return passwordEdt;
	}


	public WebElement getSubmitBtn() {
		return loginBtn;
	}
	

	
	// Buisiness libraries
	
	public void login(String username,String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
	}
	
	
	
	
	
}
