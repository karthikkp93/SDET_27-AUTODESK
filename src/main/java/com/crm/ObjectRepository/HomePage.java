package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {


	// Create seperate class for home page
	
	
	// Step 2 Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;	
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;	
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;	
	
	@FindBy(linkText="Documents")
	private WebElement documentsLnk;	
	
	@FindBy(linkText="Email")
	private WebElement emailLnk;	
	

	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleticketsLnk;
	

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	//step 3 initilization
	public HomePage(WebDriver driver)
		{
		PageFactory.initElements(driver, this);
	}
	
	//step 4 utilization
	
	public WebElement getorganizationsLnk() {
	return organizationsLnk;
	}

	

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getDocumentsLnk() {
		return documentsLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getTroubleticketsLnk() {
		return troubleticketsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
	//step 5 business libraries to click on organizations
	public void clickOnorganizationsLnk()
	{
		organizationsLnk.click();
	}
	
	//business libraries to click on contacts
	
	public void clickOncontactsLnk()
	{
		contactsLnk.click();
	}
	
	//business libraries for logout
	
	public void logout(WebDriver driver)
	{
		mouseOverOnElement(driver, administratorImg);
		signoutLnk.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
