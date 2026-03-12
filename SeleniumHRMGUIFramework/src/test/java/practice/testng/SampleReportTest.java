package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest 
{
	public ExtentReports report;
	
	@BeforeSuite 
	public void configBS()
	{
		       //Report configuration
				ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
				
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				
				//Environment Information
				report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS","windows-11");
				report.setSystemInfo("Browser","CHROME-100");
	}
	
	@AfterSuite 
	public void configAS()
	{
		report.flush();
	}
	
	
	
	
	@Test
	public void createContactTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8888/index.php?action=index&module=Home");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String src=ts.getScreenshotAs(OutputType.BASE64);
		
		
		ExtentTest test=report.createTest("createContactTest");
		
		test.log(Status.INFO,"Login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFfC".equals("HDFC"))
		{
			test.log(Status.PASS,"contact is created");
		}
		else
		{
			test.addScreenCaptureFromBase64String(src,"ErrorFile");
			//test.log(Status.FAIL,"contact is not created");
		}
		
	}
	
	@Test(enabled=false)
	public void createContactWithOrgTest()
	{
		
		
		ExtentTest test=report.createTest("createContactWithOrg");
		
		test.log(Status.INFO,"Login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS,"contact is created");
		}
		else
		{
			test.log(Status.FAIL,"contact is not created");
		}
		
	}
	
	@Test(enabled=false)
	public void createContactWithPhoneNumberTest()
	{
		ExtentTest test=report.createTest("createContactWithPhoneNumber");
		
		test.log(Status.INFO,"Login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS,"contact is created");
		}
		else
		{
			test.log(Status.FAIL,"contact is not created");
		}
		
	}

}
