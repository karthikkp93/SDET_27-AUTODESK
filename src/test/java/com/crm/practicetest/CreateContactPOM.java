package com.crm.practicetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.crm.ObjectRepository.CreateNewOrganizationPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;
import com.crm.genericutility.WebDriverUtility;

public class CreateContactPOM {

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
		 String orgName=eLib.getDataFromExcel("create", 3, 2)+randomNum;
		 String contactName=eLib.getDataFromExcel("create", 4, 1)+randomNum;
	
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
		 driver.manage().window().maximize();
		 driver.get(URL);
		 
		 // login to app
	     LoginPage lp = new LoginPage(driver);
          lp.login(USERNAME, PASSWORD);
		 
		 //navigate to organization module
		  HomePage hp = new HomePage(driver);
		   hp.clickOnorganizationsLnk();
		   
		 
		 // click on create organization button
		   CreateOrganizationPage op = new CreateOrganizationPage(driver);
				   op.clickOnCreateOrg();
		   
				 // enter all the details of create org
				   CreateNewOrganizationPage oip = new CreateNewOrganizationPage(driver);
				   oip.createOrg(orgName);
		
				   //verify orgname in hedarer
				 
				  OrganizationInfoPage oi = new OrganizationInfoPage(driver);
				  String actMsg=oi.getOrgInfo();
				  
				/*  if(actMsg.contains(orgName))
				  {
					  System.out.println(orgName+" is created pass");
				  }
		  
				  else
				  {
					  
					  System.out.println(orgName+"is not created fail");
				  }*/
					  
				  Assert.assertTrue(actMsg.contains(orgName));
				  System.out.println("org is  created");
				  
		 
		
		 
		 
		 

		 wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		 
		 driver.findElement(By.linkText("Sign Out")).click();
		 
		 driver.close();
		 
	

}
	}
}

		