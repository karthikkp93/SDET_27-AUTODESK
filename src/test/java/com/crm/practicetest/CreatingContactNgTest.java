package com.crm.practicetest;

import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.genericutility.BaseClass;

@Listeners (com.crm.genericutility.ListnerImplementation.class)

public class CreatingContactNgTest extends BaseClass{
	
	private static final String CNAME=null;
	
	
	@Test
	public void CreatingContactNgTest() throws Throwable, Throwable {
		//get random number
		int randomNum=jLib.getRandomNumber();
		
		
		//read the data from ecxel sheet
		 String orgName=eLib.getDataFromExcel("create", 3, 2)+randomNum;
	
		 HomePage hp = new HomePage(driver);
		   hp.clickOncontactsLnk();
		   AssertJUnit.fail();
		   
		   
		   //click on contact 
		   CreateContactPage cp = new CreateContactPage(driver);
		   cp.CreateContactPage(null, null);
		   
		   CreateContactPage ccp = new CreateContactPage(driver);
		   ccp.CreateContactPage(CNAME, null);
		   
		   hp.logout(driver);
		   

	
}
}
