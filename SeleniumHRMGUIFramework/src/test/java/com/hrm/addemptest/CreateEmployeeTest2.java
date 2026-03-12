package com.hrm.addemptest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateEmployeeTest2 {

	public static void main(String[] args) throws IOException
	{
		//read data from user to launch the specific browser
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter Browser (chrome/edge): ");
        String browser = sc.next();

        //read data from properties file
        FileInputStream fis = new FileInputStream("C:\\Users\\VRCR\\OneDrive\\Desktop\\commondata.properties");
        Properties prop = new Properties();
        prop.load(fis);
        
       //Generate random number
        Random random=new Random();
		int randomInt=random.nextInt(1000);
		System.out.println(randomInt);
        
       //read data from excelfile
        FileInputStream fis1 = new FileInputStream("C:\\Users\\VRCR\\OneDrive\\Desktop\\EmployeeData.xlsx");
        Workbook workbook=WorkbookFactory.create(fis1);
		Sheet sheet=workbook.getSheet("EmployeeData");
		String fn=sheet.getRow(2).getCell(0).toString()+randomInt;
		String mn=sheet.getRow(2).getCell(1).toString();
		String ln=sheet.getRow(2).getCell(2).toString();
		String id=sheet.getRow(2).getCell(3).toString();

        WebDriver driver=null;
        if (browser.equals("chrome")) 
        {
            
            driver = new ChromeDriver();
        } 
        else if (browser.equals("edge")) 
        {
            
            driver = new EdgeDriver();
        } 
        else 
        {
            System.out.println("Invalid browser name");
            return;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        

        
        //read commondata from propertiesfile
        driver.get(prop.getProperty("url"));
        driver.findElement(By.name("username")).sendKeys(prop.getProperty("Username"));
        driver.findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        
        //read testscriptdata from excel
        driver.findElement(By.name("firstName")).sendKeys(fn);
        driver.findElement(By.name("middleName")).sendKeys(mn);
        driver.findElement(By.name("lastName")).sendKeys(ln);
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(id);
        driver.findElement(By.xpath("//button[@type='submit']")).click();


	}

}
