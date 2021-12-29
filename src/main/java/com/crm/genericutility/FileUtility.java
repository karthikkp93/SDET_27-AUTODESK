package com.crm.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {

	/**
	 * @author Dell
	 * @throws Throwable 
	 * 
	 */
	public String getPropertyKeyValue(String Key) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(Key);
		return value;
		
		
	}
	
}
