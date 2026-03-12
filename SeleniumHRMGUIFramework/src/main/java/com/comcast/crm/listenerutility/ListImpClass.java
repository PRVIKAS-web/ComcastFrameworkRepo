package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.baseutility.BaseClass;

public class ListImpClass implements ITestListener,ISuiteListener
{
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;
	
	
	
  public void onStart(ISuite suite)
  {
	  String time=new Date().toString().replace(" ", "_").replace(":", "_");
	  System.out.println("Report configuration");
	  //Report configuration
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+"+.html");
		
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//Environment Information
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","windows-11");
		report.setSystemInfo("Browser","CHROME-100");

  }
  
  public void onFinish(ISuite suite)
  {
	  System.out.println("Report backup");
	  report.flush();
  }
  
  public void onTestStart(ITestResult result)
  {
	  System.out.println("======"+result.getMethod().getMethodName()+"====START====");
	  test=report.createTest(result.getMethod().getMethodName());
	  test.log(Status.INFO, result.getMethod().getMethodName()+"====STARTED====");
  }
  
  public void onTestSucess(ITestResult result)
  {
	  System.out.println("======"+result.getMethod().getMethodName()+"====END====");
	  test.log(Status.PASS, result.getMethod().getMethodName()+"====COMPLETED====");
  }
  
  
  public void onTestFailure(ITestResult result)
  {
	  String testname=result.getMethod().getMethodName();
	  
	   TakesScreenshot ts= (TakesScreenshot)BaseClass.sdriver;
		
	    String src=ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(src,testname+" "+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"====failed====");

		
		
  }

  
  
}
