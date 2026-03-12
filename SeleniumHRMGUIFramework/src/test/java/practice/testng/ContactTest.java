package practice.testng;

import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class ContactTest extends BaseClass
{
	@Test(priority=1)
	public void createContactTest()
	{
		System.out.println("Execute createContactTest--->hdfc");
	}
	
	@Test(priority=2,dependsOnMethods=" createContactTest")
	public void modifyContactTest()
	{
		System.out.println("Execute modifyContactTest-->hdfc-->icici");
	}
	
	@Test(priority=3,dependsOnMethods="modifyContactTest")
	public void deleteContactTest()
	{
		System.out.println("Execute deleteContactTest--->icici");
	}

}
