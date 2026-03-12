package practice.datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBacktoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
       FileInputStream fis=new FileInputStream("C:\\Users\\VRCR\\OneDrive\\Desktop\\LoginData.xlsx");
		
		Workbook workbook=WorkbookFactory.create(fis);
		
		Sheet sheet=workbook.getSheet("LoginData");
		
		Row row=sheet.getRow(1);
		
		Cell cell=row.createCell(5);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("Pass");
		
		FileOutputStream fos=new FileOutputStream(new File("C:\\Users\\VRCR\\OneDrive\\Desktop\\LoginData.xlsx"));
        workbook.write(fos);
	}

}
