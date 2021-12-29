package com.crm.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class BaseClass {

	public  WebDriver driver;
	
	//Object Creation for Lib/
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public DataBaseUtility dLib=new DataBaseUtility();
	public static WebDriver sdriver;
	
	
	


	@BeforeSuite (groups = {"smokeSuite","RegressionSuite"})
	public void dbconnection() {
		dLib.ConnectToDB();
		System.out.println("========================connect to DB========================");

	}
//@Parameters("browser")
	@BeforeClass (groups = {"smokeSuite","RegressionSuite"})
	public void launchBrowser() throws Throwable
	{

		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		} else if(BROWSER.equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");

		}
		
		sdriver=driver;
		wLib.waitForPageToLoad(driver);
		wLib.Maximisewindow(driver);
		driver.get(URL);
		System.out.println("=============Launch the Browser=======");

	}

	@BeforeMethod (groups = {"smokeSuite","RegressionSuite"})
	public void loginToApp() throws Throwable {
		//common Data/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("login...successfull");


	}


	@AfterMethod (groups = {"smokeSuite","RegressionSuite"})
	public void logoutApp() {
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		System.out.println("...logout...succefull");

	}

	@AfterClass (groups = {"smokeSuite","RegressionSuite"})
	public void closeBrowser() {
		driver.quit();
		System.out.println("=============Close the Browser=======");

	}

	@AfterSuite (groups = {"smokeSuite","RegressionSuite"})
	public void closeDbconnection() {
		dLib.closeDB();
		System.out.println("========================close DB========================");
}
}
