package com.crm.practicetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;
import com.crm.genericutility.WebDriverUtility;

public class CreateNewContact  {
	public static void  main(String[] args) throws Throwable {

	JavaUtility jLib=new JavaUtility();
	FileUtility fLib=new FileUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	ExcelUtility eLib= new  ExcelUtility();
	
	// creating a random number
	int RandomNum=jLib.getRandomNumber();
	
	//read the data from property file
	String BROWSER=fLib.getPropertyKeyValue("browser");
	String URL=fLib.getPropertyKeyValue("url");
	String PASSWORD=fLib.getPropertyKeyValue("password");
	String USERNAME=fLib.getPropertyKeyValue("username");
	
			
	
	
	//launch the browser
	WebDriver driver = null;{
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("ie")) {
			driver=new InternetExplorerDriver();
			
		}
	       wLib.waitForPageToLoad(driver);
	       driver.manage().window().maximize();
	       driver.get(URL);
	       
	       
	  	 // login to app
			 
			 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			 driver.findElement(By.id("submitButton")).click();
			 
			 //navigate to contact page
			 driver.findElement(By.linkText("Contacts")).click();
			 
			 //navigate to create contact page
			 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			 
			 //create new contact with org name
			 driver.findElement(By.name("lastname")).sendKeys("ram");
			 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	
			wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("\"//img[@src='themes/softed/images/user.PNG']\"")));
			driver.findElement(By.linkText("Sign Out")).click();
			driver.close();}}
			
}



	

