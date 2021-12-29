package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{

	//step 1
	//step 2
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createorgLookupImg;
	
	
	@FindBy(name = "search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name = "submit")
	private WebElement searchNowBtn;
	
	//step 3 
	public  CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step 4

	public WebElement getCreateorgLookupImg() {
		return createorgLookupImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	//business libraries
	public void clickOnCreateOrg() {
		createorgLookupImg.click();
	}
	
	}
	
	
	

