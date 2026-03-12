package com.crm.comcast.contactTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class CreateContactTest extends BaseClass
{
	
	
	
	@Test(groups="SmokeTest")
	public void createContact() 
	{
		System.out.println("execute createContact and verify");
	}
	@Test(groups="RegressionTest")
	public void createContactWithDate()
	{
		System.out.println("execute createContact WithDate and verify");
	}

}
