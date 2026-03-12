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

import com.hrm.generic.fileutility.ExcelUtility;
import com.hrm.generic.fileutility.FileUtility;
import com.hrm.generic.webdriverutility.JavaUtility;
import com.hrm.generic.webdriverutility.WebDriverUtility;

public class CreateEmployeeTest {

	public static void main(String[] args) throws IOException
	{
		//read data from user to launch the specific browser
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter Browser (chrome/edge): ");
        String browser = sc.next();

        //read data from properties file
        FileUtility flib=new FileUtility();
        
        
       //Generate random number
        Random random=new Random();
		int randomInt=random.nextInt(1000);
		System.out.println(randomInt);
        
       //read data from excelfile
        ExcelUtility elib=new ExcelUtility();
        
        JavaUtility jlib=new JavaUtility();
        String startdate=jlib.getSystemDate();
        String enddate=jlib.getRequiredDateyyyyDDMM(30);
        WebDriverUtility wlib=new  WebDriverUtility();
        
        
        
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
        wlib.waitforpagetoload(driver); 
        
        

        
        //read commondata from propertiesfile
        driver.get(flib.getDataFromPropertyFile("url"));
        driver.findElement(By.name("username")).sendKeys(flib.getDataFromPropertyFile("Username"));
        driver.findElement(By.name("password")).sendKeys(flib.getDataFromPropertyFile("Password"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        
        //read testscriptdata from excel
        driver.findElement(By.name("firstName")).sendKeys(elib.getDataFromExcel("EmployeeData", 1, 0)+ jlib.getRandomNumber());
        driver.findElement(By.name("middleName")).sendKeys(elib.getDataFromExcel("EmployeeData",1,1));
        driver.findElement(By.name("lastName")).sendKeys(elib.getDataFromExcel("EmployeeData",1,2));
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(elib.getDataFromExcel("EmployeeData",1,3));
        driver.findElement(By.xpath("//button[@type='submit']")).click();


	}

}
