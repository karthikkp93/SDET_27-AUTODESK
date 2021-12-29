package com.crm.producttest;

import java.io.FileInputStream;
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
import org.openqa.selenium.interactions.Actions;

public class CreatingProductWithProductInfo {
	
	//step1: get java representation object of the physical state
	FileInputStream fis=new FileInputStream("/.data/commondata.properties");
	
	//step 2 :create an object of properties class to load all keys
	Properties pobj=new Properties();
	pobj.load(fis);
	
	
	//step3 :read the value using get property ("key")
	String BROWSER= pobj.getProperty("browser");
	 String URL= pobj.getProperty("url");
	 String USERNAME= pobj.getProperty("username");
	 String PASSWORD= pobj.getProperty("password");
	 
	 //get random num
	 Random ran=new Random();
	 int  ranDomNum=ran.nextInt(10000);
	 
	//read the test data from excel file
	 FileInputStream fis_e=new FileInputStream("/.data/testdata.xlsx");
	 Workbook wb=WorkbookFactory.create(fis_e);
	 Sheet sh=wb.getSheet("create");
	Row row=sh.getRow(4);
	String prodname=row.getCell(5).getStringCellValue();
	
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
	 
	 driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	 driver.findElement(By.name("Product Name")).sendKeys("keyboard");
	 driver.findElement(By.name("Product No")).sendKeys("123");
	 driver.findElement(By.name("Product Active")).click();
	 driver.findElement(By.id("jscal_trigger_sales_start_date")).click();
	 driver.findElement(By.name("Part Number")).sendKeys("12");
	 
	 
	 
	 driver.findElement(By.xpath("//input[@name='sales_start_date']/following-sibling::img")).click();
	
	 driver.findElement(By.name("Part Number")).sendKeys("12");
	 driver.findElement(By.name("Part Number")).sendKeys("12");
	 driver.findElement(By.name("Part Number")).sendKeys("12");
	 driver.findElement(By.name("Part Number")).sendKeys("12");
	 driver.findElement(By.name("Part Number")).sendKeys("12");
	 
	 
	 
	 driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	 
	 
	 
	 driver.findElement(By.name("Vendor Name")).sendKeys("12");
	 driver.findElement(By.name("Website")).sendKeys("www.nokia.com");
	 driver.findElement(By.name("Vendor Part No")).sendKeys("12");
	 driver.findElement(By.name("Mfr Part No")).sendKeys("12");
	 driver.findElement(By.name("Product Sheet")).sendKeys("product details");
	 driver.findElement(By.name("Serial No")).sendKeys("12");
	 driver.findElement(By.name("GL Account")).click();
	 
	 String actsuc_msg = driver.findElement(By.name("Product Information")).getText();
	 if(actsuc_msg .contains(prodname)) {
		 System.out.println("product is sucessfully added");
	 }
	 else {
		 System.out.println("product is not created");
	 }
	 Actions act=new Actions(driver);
	 act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	 driver.findElement(By.linkText("sign out")).click();
	 driver.quit();
	 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	 
	 
	

}
