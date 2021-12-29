package com.crm.producttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;
import com.crm.genericutility.WebDriverUtility;

public class CreatingProductInfoForProduct {

	public static void main(String[] args) throws Throwable {
		
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
	
		String url=fLib.getPropertyKeyValue("url");
		String username=fLib.getPropertyKeyValue("username");
		String Password=fLib.getPropertyKeyValue("passowrd");
		String browser=fLib.getPropertyKeyValue("browser");
		String productName=fLib.getPropertyKeyValue("product name");
		
		
		//step3 :read the value using get property ("key")
		
		
		
		 
		 //get random num
		int randomNum=jLib.getRandomNumber();
		 
		 //login to app
		
		
		
		//read the test data from excel file

		
		String BROWSER= fLib.getPropertyKeyValue("browser");
		 String URL= fLib.getPropertyKeyValue("url");
		 String USERNAME= fLib.getPropertyKeyValue("username");
		 String PASSWORD= fLib.getPropertyKeyValue("Password");
		 
		

		
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
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		 driver.findElement(By.linkText("product")).click();
		 
		 
		 //click on product button
		 driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		 
		 

	}

}
}
