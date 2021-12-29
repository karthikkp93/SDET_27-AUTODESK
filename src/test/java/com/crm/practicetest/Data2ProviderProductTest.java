package com.crm.practicetest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Data2ProviderProductTest {

	@Test(dataProvider = "getdata")
	public void readDataFromData2ProviderProductTest(String name,int qty,String colour,String model)
	{
		System.out.println("mobile name---->"+name+"mobile name ---->"+qty+"colour----->"+colour+"model------>"+model);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArry=new Object[5][4];
		
		objArry[0][0]="iphone";
		objArry[0][1]=10;
		objArry[0][2]="black";
		objArry[0][3]="11pro";
		
		objArry[1][0]="samsung";
		objArry[1][1]=20;
		objArry[1][2]="blue";
		objArry[1][3]="Galaxy";
		
		objArry[2][0]="vivo";
		objArry[2][1]=30;
		objArry[2][2]="green";
		objArry[2][3]="V12";
		
		objArry[3][0]="Realme";
		objArry[3][1]=50;
		objArry[3][2]="Black";
		objArry[3][3]="6 pro";
		
		objArry[4][0]="MI";
		objArry[4][1]=40;
		objArry[4][2]="Red";
		objArry[4][3]="11";
		
		return objArry;
		
	}
	
}
	
	
	
	
	

