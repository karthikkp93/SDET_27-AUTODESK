package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createcontact;
	
	@FindBy(name = "search_text")
	private WebElement searchfor;
	
	@FindBy(name = "submit")
	private WebElement searchnow;
	
	//step 3 initilization
		public ContactsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//step 4 
		public WebElement getCreatecontact() {
			return createcontact;
		}

		public WebElement getSearchfor() {
			return searchfor;
		}

		public WebElement getSearchnow() {
			return searchnow;
		}
		
		

	

}
