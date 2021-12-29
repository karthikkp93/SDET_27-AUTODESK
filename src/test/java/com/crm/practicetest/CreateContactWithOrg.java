package com.crm.practicetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;
import com.crm.genericutility.WebDriverUtility;

public class CreateContactWithOrg {

	public static void main(String[] args) throws Throwable {
		// create object to libraries
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		
		//get random data
		int randomNum=jLib.getRandomNumber();
		
		//read the data from properties files

		String BROWSER= fLib.getPropertyKeyValue("browser");
		 String URL= fLib.getPropertyKeyValue("url");
		 String USERNAME= fLib.getPropertyKeyValue("username");
		 String PASSWORD= fLib.getPropertyKeyValue("password");
		 
		 
		 //read the data from excel file
		 String orgName=eLib.getDataFromExcel("create", 4, 2)+randomNum;
		 String contactName=eLib.getDataFromExcel("create", 4, 3)+randomNum;
		 
		 //launch the browser
		 
			
		 WebDriver driver;{
		 if(BROWSER.equals("firefox")) {
			 driver=new FirefoxDriver();}
		 else if(BROWSER.equals("chrome")) {
			 driver=new ChromeDriver();}
		 else if(BROWSER.equals("ie")) {
			 driver=new InternetExplorerDriver();}
		 else {
			 driver=new ChromeDriver();
		 }
		 
		 wLib.waitForPageToLoad(driver);
		 driver.get(URL);
		 
		 // login to app
		 
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		 
		 //navigate to org page
		 driver.findElement(By.linkText("Organizations")).click();
		 
		 
		 //navigate tocreate org page
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 
		 //creating new org
		 driver.findElement(By.name("accountname")).sendKeys(orgName);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 WebElement headerWb=driver.findElement(By.className("dvHeaderText"));
		 wLib.waitForElementToBeClickable(driver, headerWb);
		 
		 //navigate to contact page
		 driver.findElement(By.linkText("Contacts")).click();
		 
		 //navigate to create contact page
		 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		 
		 //create new contact with org name
		 driver.findElement(By.name("lastname")).sendKeys(contactName);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 
		 
		 wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		 
		 driver.findElement(By.linkText("Sign Out")).click();
		 
		 driver.close();
		 }
		 
	}
}

		 
	
	
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

	


