package com.crm.contacts;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Createnewcontact2 {

	public static void main(String[] args) throws Throwable {
	FileInputStream fis= new FileInputStream("./data/commonData.propreties");
		 
		 
		 Properties Pobj=new Properties();
		 Pobj.load(fis);
		 
		 String BROWSER= Pobj.getProperty("browser");
		 String URL= Pobj.getProperty("url");
		 String USERNAME= Pobj.getProperty("username");
		 String PASSWORD= Pobj.getProperty("password");
		 
		 WebDriver driver=new ChromeDriver();
		 driver.get(URL);
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		 
		 
		 
		 
		 
		 
		
	}

}
