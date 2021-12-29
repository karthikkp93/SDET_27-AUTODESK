package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	
	

	// Create seperate class for home pa
	
	// Step 2 Declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(id="title")
	private WebElement titleEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//step 3 initilization
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step 4 utilization

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getTitleEdt() {
		return titleEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business libraries to create contacts
	public void CreateContactPage(String ramm,String karthik)
	{
		lastNameEdt.sendKeys(ramm);
		titleEdt.sendKeys(karthik);
		saveBtn.click();
	}
	

}
