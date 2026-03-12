package com.crm.generic.baseutility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass 

{
	public WebDriver driver;
	public static WebDriver  sdriver;
	
	
	@BeforeSuite(groups= {"SmokeTest","RegressionTest"})
	public void confingBS()
	{
		System.out.println("connect db,report config");
		
		
	}
	
	@BeforeClass(groups= {"SmokeTest","RegressionTest"})
	public void confingBC()
	{
		System.out.println("launch the browser");
		
        driver=new ChromeDriver();
        
        sdriver=driver;
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@BeforeMethod(groups= {"SmokeTest","RegressionTest"})
	public void confingBM()
	{

	    System.out.println("login");
	
         driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();   
	}
	
	@AfterMethod(groups= {"SmokeTest","RegressionTest"})
	public void confingAM()
	{
		System.out.println("logout");
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}
	
	@AfterClass(groups= {"SmokeTest","RegressionTest"})
	public void confingAC()
	{
		System.out.println("close the browser");
		driver.close();
	}
	
	@AfterSuite(groups= {"SmokeTest","RegressionTest"})
	public void confingAS()
	{
		System.out.println("close db,report backup");
		
	}

}
