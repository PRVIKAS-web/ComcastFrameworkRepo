package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HomePageVerificationTest 
{
	@Test
	public void homepagetest(Method mtd)
	{
		Reporter.log(mtd.getName()+" Test Start");
		String expectitle="Home";
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();
		
		String acttitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
//		if(acttitle.trim().equals(expectitle))
//		{
//			Reporter.log(expectitle+"is verified");
//		}
//		else
//		{
//			Reporter.log(expectitle+"is not verified");
//		}
		
		Assert.assertEquals(acttitle, expectitle);
		Reporter.log(mtd.getName()+" Test end");
		
		
	}
	
	@Test
	public void verifylogohomepagetest(Method mtd)
	{
		Reporter.log(mtd.getName()+" Test Start");
				
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();
		
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
//		if(status)
//		{
//			Reporter.log("logo is verified");
//		}
//		else
//		{
//			Reporter.log("logo is not  verified");
//		}
		
		
		Assert.assertTrue(status);
		
		Reporter.log(mtd.getName()+" Test end");
		
	}
	
	

}
