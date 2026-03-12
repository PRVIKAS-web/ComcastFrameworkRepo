package com.comcast.crm.orgtest;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.objrepo.CreateNewOrganizationPage;
import com.comcast.crm.objrepo.HomePage;
import com.comcast.crm.objrepo.LoginPage;
import com.comcast.crm.objrepo.OrganizationInfoPage;
import com.comcast.crm.objrepo.OrganizationPage;
import com.hrm.generic.fileutility.FileUtility;

public class CreateOrganizationTest 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
	        //read data from user to launch the specific browser
			Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Browser (chrome/edge): ");
	        String browser = sc.next();
	        
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
	        
	        //read data from properties file
	        FileUtility flib=new FileUtility();
	        
	        //read commondata from propertiesfile
	        driver.get(flib.getDataFromPropertyFile("url"));
	        
	        LoginPage lp=new LoginPage(driver);
	        lp.loginToapp("admin", "admin");
	        
	        HomePage hp=new HomePage(driver);
	        hp.getOrgLink().click();
	        
	        OrganizationPage op=new OrganizationPage(driver);
	        op.getCreateNewOrgBtn().click();
	        
	        CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	        cnop.createorg("abfffx","1-5");
	        
	        OrganizationInfoPage  oip=new OrganizationInfoPage(driver);
	        Thread.sleep(3000);
	        String actorgname=oip.getHeadermsg().getText();
	        System.out.println("$$$$");
	        if(actorgname.contains("abfffx"))
	        {
	        	System.out.println("org name is verified"+"pass");
	        }
	        else
	        {
	        	System.out.println("org name is not verified"+"fail");
	        }
	        
	        
	        
	        
	        
	        
	}

}
