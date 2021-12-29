package com.crm.contacts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class CreatenewOrg {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream("./data/commondata.properties");
		 
		 
		 Properties Pobj=new Properties();
		 Pobj.load(fis);
		 
		 String BROWSER= Pobj.getProperty("browser");
		 String URL= Pobj.getProperty("url");
		 String USERNAME= Pobj.getProperty("username");
		 String PASSWORD= Pobj.getProperty("password");
		 
		 //get random num
		 Random ran=new Random();
		 int  ranDomNum=ran.nextInt(10000);
		 
		 //read the test data from excel file
		 FileInputStream fis_e= new FileInputStream("./data/testdata.xlsx");
		 Workbook wb=WorkbookFactory.create(fis_e);
	   Object sh = wb.getSheet("org");
	   sh.g
		 String orgname=row.getCell(2).getStringCellValue()+ranDomNum;
		 WebDriver driver;
		 if(BROWSER.equals("firefox")) {
			 driver=new FirefoxDriver();}
		 else if(BROWSER.equals("chrome")) {
			 driver=new ChromeDriver();}
		 else if(BROWSER.equals("ie")) {
			 driver=new InternetExplorerDriver();}
		 else {
			 driver=new ChromeDriver();
		 }
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get(URL);
		 
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		 
		 
		 driver.findElement(By.linkText("Organizations")).click();
		 
		 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		 
		 driver.findElement(By.name("accountname")).sendKeys(orgname);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 String actsuc_msg=driver.findElement(By.className("dvHeadertext")).getText();
		 if(actsuc_msg.contains(orgname)) {
			 System.out.println("org is created");
		 }
		 else {
			 
			 System.out.println("org is not created");
		 }
		 
		 Actions act=new Actions(driver);
		 act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		 driver.findElement(By.linkText("sign out")).click();
		 driver.quit();
		 
		 
		 
		 
		 
		 
		 
		 
		 }

		 
		 
		 
		 
		 
		 
		
				 
		 
		 
		 
		 
	}


