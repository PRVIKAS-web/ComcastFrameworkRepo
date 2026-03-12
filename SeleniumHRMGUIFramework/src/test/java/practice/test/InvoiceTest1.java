package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class InvoiceTest1 extends BaseClass
{
	
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateSim()
	{
		System.out.println("execute createInvoiceTest");
		
		String acttitle=driver.getTitle();
		
		Assert.assertEquals(" ", "Login");
	}

}
