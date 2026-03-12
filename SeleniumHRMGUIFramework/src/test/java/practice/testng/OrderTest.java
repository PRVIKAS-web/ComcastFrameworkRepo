package practice.testng;

import org.testng.annotations.Test;

public class OrderTest 
{
	@Test(invocationCount=10)
	public void createorderTest()
	{
		System.out.println("execute  createorderTest ");
	}

}
