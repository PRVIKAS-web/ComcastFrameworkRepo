package com.comcast.crm.orgtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest
{
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
	
	@BeforeSuite
	public void confingBS()
	{
		System.out.println("execute confingBS");
	}
	
	@AfterSuite
	public void confingAS()
	{
		System.out.println("execute confingAS");
	}
	
	
	@Test
	public void createContact()
	{
		System.out.println("execute createContact");
	}

}
