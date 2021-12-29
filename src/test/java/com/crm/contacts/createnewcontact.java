package com.crm.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createnewcontact {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
// get the java representation of object of physical file
		FileInputStream fis = new FileInputStream("./data/commondata.properties");
		// create an object to property class to load all the keys
		
		Properties pobj = new Properties();
		pobj.load(fis);
		pobj.getProperty("browser");
		pobj.getProperty("url");
		pobj.getProperty("username");
		pobj.getProperty("password");
		
		new ChromeDriver();
		
		
		
		
		
		
		
		
		
	}

}

