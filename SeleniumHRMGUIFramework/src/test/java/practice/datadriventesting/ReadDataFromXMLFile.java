package practice.datadriventesting;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXMLFile {

	@Test
	public void sampleTest(XmlTest test)
	{
		System.out.println(test.getParameter("url"));
		System.out.println(test.getParameter("Username"));
		System.out.println(test.getParameter("Password"));
	}

}
