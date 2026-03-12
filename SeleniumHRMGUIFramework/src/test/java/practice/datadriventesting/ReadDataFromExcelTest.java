package practice.datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\VRCR\\OneDrive\\Desktop\\LoginData.xlsx"));
		
		Workbook workbook=WorkbookFactory.create(fis);
		
		Sheet sheet=workbook.getSheet("LoginData");
		
		Row row=sheet.getRow(1);
		 
		Cell cell=row.getCell(2);
		
		String cell_value=cell.getStringCellValue();
		
		System.out.println(cell_value);

	}

}
