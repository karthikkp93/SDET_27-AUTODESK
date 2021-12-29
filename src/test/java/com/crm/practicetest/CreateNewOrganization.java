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

public class CreateNewOrganization {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
	 JavaUtility jLib = new JavaUtility();
	 FileUtility fLib = new FileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	//create a random number
	int RandomNum=jLib.getRandomNumber();
	
	//read the data from excel sheet
	String BROWSER=fLib.getPropertyKeyValue("browser");
	String URL=fLib.getPropertyKeyValue("url");
	String USERNAME =fLib.getPropertyKeyValue("username");
	String PASSWORD=fLib.getPropertyKeyValue("passowrd");
	
	
	//launch the browser
	WebDriver driver = null;
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else if (BROWSER.equalsIgnoreCase("ie")) {
		driver=new InternetExplorerDriver();
	}
	
	 //read the data from excel file
	 String orgName=eLib.getDataFromExcel("create", 3, 2)+RandomNum;
	 String contactName=eLib.getDataFromExcel("create", 4, 1)+RandomNum;

	
	wLib.waitForPageToLoad(driver);
	driver.manage().window().maximize();
	driver.get(URL);
	
	//filling all the necessary data 
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("root");
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
	
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	driver.findElement(By.name("button")).click();
	
	
	wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	driver.findElement(By.name("Sign Out")).click();
	driver.close();
	
	
	
	}

}
