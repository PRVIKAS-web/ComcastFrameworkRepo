package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTest 
{
	@Test(dataProvider="getdata")
	public void getProductInfoTest(String brandname,String productname)
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		
		WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
		
		searchbox.sendKeys(brandname,Keys.ENTER);
		
		WebElement apple15=driver.findElement(By.xpath("//span[text()='"+productname+"']//ancestor::div[@class='a-section']//descendant::span[@class='a-price-whole']"));
		
		String price=apple15.getText();
		
		System.out.println(price);	
		
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="iphone";
		obj[0][1]="iPhone 15 (256 GB) - Black";
		
		obj[1][0]="iphone";
		obj[1][1]="iPhone 15 Pro Max (512 GB) - White Titanium";
		
		return obj;
		
	}
	

}
