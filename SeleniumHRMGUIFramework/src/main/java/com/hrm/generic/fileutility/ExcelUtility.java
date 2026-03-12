package com.hrm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getDataFromExcel(String sheetname,int rowNum,int celNum) throws EncryptedDocumentException, IOException
	{
		    FileInputStream fis1 = new FileInputStream("./testscriptdata/EmployeeData.xlsx");
	        Workbook workbook=WorkbookFactory.create(fis1);
			Sheet sheet=workbook.getSheet(sheetname);
			String data=sheet.getRow(rowNum).getCell(celNum).getStringCellValue();
			workbook.close();
			return data;
			
	}
	
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 = new FileInputStream("./testscriptdata/EmployeeData.xlsx");
        Workbook workbook=WorkbookFactory.create(fis1);
        Sheet sheet=workbook.getSheet(sheetname);
        int data=sheet.getLastRowNum();
        workbook.close();
        return data;
        
	}
	
	public void setDataintoExcel(String sheetname,int rownum,int celnum,String cellvalue) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 = new FileInputStream("./testscriptdata/EmployeeData.xlsx");
        Workbook workbook=WorkbookFactory.create(fis1);
		Sheet sheet=workbook.getSheet(sheetname);
		sheet.getRow(rownum).createCell(celnum).setCellValue(cellvalue);
		
		FileOutputStream fos=new FileOutputStream("./testscriptdata/EmployeeData.xlsx");
		workbook.write(fos);
		workbook.close();
		
	}

}
