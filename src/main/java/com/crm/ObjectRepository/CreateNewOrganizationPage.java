package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.genericutility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	

	// Create seperate class for home page
	
	
	// Step 2 Declaration
	@FindBy(name="accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//step 3 initilization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step 4 utilization
	public WebElement getOrganizationEdt() {
		return organizationNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	//business libraries for create organization
	
	public void createOrg(String orgName)
	{
		organizationNameEdt.sendKeys(orgName);
	    saveBtn.click();
	}
	
	//business library for create organization with industry dropdown
	public void createOrgWithindustry(String orgName,String industryType)
	{
		organizationNameEdt.sendKeys(orgName);
		select(industryDropDown, industryType);
		saveBtn.click();
	}
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

