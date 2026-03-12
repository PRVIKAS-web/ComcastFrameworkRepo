package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;
@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class InvoiceTest extends BaseClass
{
	@Test
	public void createInvoiceTest()
	{
		System.out.println("execute createInvoiceTest");
		
		String acttitle=driver.getTitle();
		
		Assert.assertEquals(acttitle, "Login");
	}
	
	@Test
	public void createInvoiceTestWithContactTest()
	{
		System.out.println("execute createInvoiceTestWithContactTest");
	}

}
