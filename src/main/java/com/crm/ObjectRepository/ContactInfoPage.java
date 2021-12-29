package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(className = "dvHeaderText")
	  WebElement contHeaderText;
	
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getContHeaderText() {
		return contHeaderText;
	}

	//business library
		public String getcontInfo()
		{
			return(contHeaderText.getText());
		}

}
