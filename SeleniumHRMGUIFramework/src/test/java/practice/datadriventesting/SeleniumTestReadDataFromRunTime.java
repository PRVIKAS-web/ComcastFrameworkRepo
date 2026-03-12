package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class SeleniumTestReadDataFromRunTime 
{
	@Test
	public void seleniumTest() throws IOException
	{
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter Browser (chrome/edge): ");
        String browser = sc.next();
        

        //read data from properties file
        FileInputStream fis = new FileInputStream("C:\\Users\\VRCR\\OneDrive\\Desktop\\commondata.properties");
        Properties prop = new Properties();
        prop.load(fis);
        
        //READ DATA FROM COMMAND LINE
        String url=System.getProperty("url");
		System.out.println("Env Data=>URL=>"+url);
		
        
        
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
        
        //commondata from propertiesfile
        driver.get(url);
        driver.findElement(By.name("username")).sendKeys(prop.getProperty("Username"));
        driver.findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	

}
