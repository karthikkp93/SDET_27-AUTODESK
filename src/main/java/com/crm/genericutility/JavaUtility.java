package com.crm.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Dell
 *
 */

public class JavaUtility {
	/**
	 * it is used to generate random number
	 * @return 
	 * 
	 */
     public  int getRandomNumber() {
    	 Random random=new Random();
    	 int intRandom=random.nextInt(10000);
    	 return intRandom;
     }
     /**
      * used to get system date and time in IST format
      * @return
      */
    	 public String getSystemDateAndTime() {
    		Date date = new Date();
    		 return date.toString();
    	 }
    	 /**
    	  * @author Dell
    	  * used to system date in YYYY-MM-DD format
    	  * 
    	  */
    		public String getSystemDateWithFormate() {
    			Date date= new Date();
    			String dateAndTime=date.toString();
    			
    			String YYYY=dateAndTime.split(" ")[5];
    			String DD=dateAndTime.split(" ")[2];
    			int MM = date.getMonth()+1;
    			String FinalFormate=YYYY+"-"+MM+"-"+DD;
    			return FinalFormate;
    			
    			
    	 }
     }
     

