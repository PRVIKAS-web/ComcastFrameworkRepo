package com.webTable;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_With_WebTable
{

	public static void main(String[] args)
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		
		List<WebElement>data=driver.findElements(By.xpath("//tr[@class='bg-white border-b  hover:bg-orange-100']"));
		
//	   for(int i=0;i<data.size();i++)
//	   {
//		    String text=data.get(i).getText();
//			System.out.println(text+" ");
//	   }
//		for (WebElement element : data) 
//		{
//		    String text = element.getText();
//		    System.out.println(text + " ");
//		}
		
//		Iterator<WebElement> it = data.iterator();
//		while(it.hasNext())
//		{
//			String text=it.next().getText();
//		    System.out.println(text + " ");
//		}
		
		List<WebElement>evndata=driver.findElements(By.xpath("//td[position() mod 2=0]"));
		 for(int i=0;i<evndata.size();i++)
			   {
				    String text=data.get(i).getText();
					System.out.println(text+" ");
			   }


	}

}
