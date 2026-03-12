package practice.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTest 
{
	
	
	@Test
	public void createContact()
	{
		System.out.println("execute createContact");
	}
	
	@Test
	public void createContactWithDate()
	{
		System.out.println("execute createContact WithDate");
	}
	
	@BeforeMethod
	public void confingBM()
	{
		System.out.println("execute confingBM");
	}
	
	@AfterMethod
	public void confingAM()
	{
		System.out.println("execute confingAM");
	}
	
	@BeforeClass
	public void confingBC()
	{
		System.out.println("execute confingBC");
	}
	
	@AfterClass
	public void confingAC()
	{
		System.out.println("execute confingAC");
	}
	
	

}
