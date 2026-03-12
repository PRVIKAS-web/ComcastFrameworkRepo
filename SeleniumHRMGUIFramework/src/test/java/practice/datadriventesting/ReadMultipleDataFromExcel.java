package practice.datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
       FileInputStream fis=new FileInputStream(new File("C:\\Users\\VRCR\\OneDrive\\Desktop\\LoginData.xlsx"));
		
		Workbook workbook=WorkbookFactory.create(fis);
		
		Sheet sheet=workbook.getSheet("ProductData");
		
		int rowcount=sheet.getLastRowNum();
		
		
		for(int i=1;i<=rowcount;i++)
		{
			Row row=sheet.getRow(i);
			
			String first_column=row.getCell(0).toString();
			
	        String second_column=row.getCell(1).toString();
			
			System.out.println(first_column+":: "+second_column);
			
		}
		
		

	}

}
