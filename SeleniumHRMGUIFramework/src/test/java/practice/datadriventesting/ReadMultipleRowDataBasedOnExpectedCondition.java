package practice.datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleRowDataBasedOnExpectedCondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
        FileInputStream fis=new FileInputStream(new File("C:\\Users\\VRCR\\OneDrive\\Desktop\\LoginData.xlsx"));
		
		Workbook workbook=WorkbookFactory.create(fis);
		
		Sheet sheet=workbook.getSheet("LoginData");
		
		String expected_TestID="TC_02";
		
		int rowcount=sheet.getLastRowNum();
		String data2="";
		String data3="";
		String data4="";
		boolean flag=false;
		
		
		for(int i=0;i<=rowcount;i++)
		{
			String data="";
			try
			{
			data=sheet.getRow(i).getCell(0).toString();
			if(data.equals(expected_TestID))
			{
				 flag=true;
				 data2=sheet.getRow(i).getCell(2).toString();
				 data3=sheet.getRow(i).getCell(3).toString();
				 data4=sheet.getRow(i).getCell(4).toString();
				
			}
			
			}
			catch(Exception e)
			{
				
			}
			

		}
		if(flag==true)
		{
		System.out.println(data2);
		System.out.println(data3);

		System.out.println(data4);
		}else
		{
			System.out.println(expected_TestID+" is not available");
		}
		

	}

}
