package com.crm.practicetest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateNewOrganizationPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.genericutility.BaseClass;
@Listeners (com.crm.genericutility.ListnerImplementation.class)
public class CreatingOrgNGTest extends BaseClass {
	
	
	
	@Test(groups = "RegressionSuite")
	public void CreatingOrgNGTest() throws Throwable, Throwable {
		
		//get random number
		int randomNum=jLib.getRandomNumber();
		
		
		//read the data from ecxel sheet
		 String orgName=eLib.getDataFromExcel("create", 3, 2)+randomNum;
		 
		 //navigate to organization module
		 HomePage hp = new HomePage(driver);
		   hp.clickOnorganizationsLnk();
		   
		   //click on create organiztion button
		   CreateOrganizationPage op = new CreateOrganizationPage(driver);
		   op.clickOnCreateOrg();
   
		   //enter all the details and create organization
		   CreateNewOrganizationPage oip = new CreateNewOrganizationPage(driver);
		   oip.createOrg(orgName);

		   // verify organization name in header message
		   OrganizationInfoPage oi = new OrganizationInfoPage(driver);
			  String actMsg=oi.getOrgInfo();
			  
			//  if(actMsg.contains(orgName))
			  //{
				//  System.out.println(orgName+" is created pass");
			  //}
			  
			  //else
			  //{
				//  System.out.println(orgName+" is not created");
			  //}
			  
			  Assert.assertTrue(actMsg.contains(orgName));
			  System.out.println("org is  created");
			  
			  
			  
			  
	}
	
	public void demo()
	{
		System.out.println("demo");
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			  
		   
		   
		   
		   
		   
		   
		   
		 
	

	

