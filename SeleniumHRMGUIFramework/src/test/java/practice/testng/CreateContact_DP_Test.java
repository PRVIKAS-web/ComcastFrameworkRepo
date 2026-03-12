package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test 
{
	@Test(dataProvider="getdata ")
	public void createcontact(String firstname,String lastname)
	{
		System.out.println(firstname+" "+lastname);
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="Deepak";
		obj[0][1]="P";
		
		obj[1][0]="Deepak";
		obj[1][1]="R";
		
		obj[2][0]="Deepak";
		obj[2][1]="S";
		
		return obj;
		
		
		
		
	}

}
