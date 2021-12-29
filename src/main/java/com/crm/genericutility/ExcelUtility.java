package com.crm.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Dell
 *
 */

public class ExcelUtility {
/**
 * it is used to read the data from excel base don below arguments 
 * @param sheetName
 * @param rowNumb
 * @param cellNum
 * @return Data
 * @throws IOException 
 * @throws EncryptedDocumentException 
 * @throws  Throwable
 */
	
	public String getDataFromExcel(String sheetName,int rowNum,int CelNum) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./data/testdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	String data = row.getCell(CelNum).getStringCellValue();
	wb.close();
	return data;
	}
	/**
	 * @param sheetName
	 * @author Dell
	 * @return
	 * @throws
	 */
	
        public int getRowCount(String sheetName) throws Throwable  {
		
		FileInputStream fis = new FileInputStream("./data/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
}
	
	/**
	 * used to get the last used row number on specific sheet
	 
	  * 
	  * @param sheetName
	  * @param rowNum
	  * @param cellNum
	  * @return
	 * @throws Throwable  
	  */
	
	public void setDataExcel(String sheetName,int rowNum,int cellNum, String data) throws Throwable  {
		
		FileInputStream fis = new FileInputStream("./data/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(cellNum);
		cel.setCellValue(data);
		FileInputStream fos=new FileInputStream("./data/testdata.xlsx");
		
		
		
		
		
		
	}
	
	
}


