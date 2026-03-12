package practice.datadriventesting;

import org.junit.Test;

public class ReadRunTimeMavenParameters 
{
	@Test 
	public void runtimeparametertest()
	{
		String url=System.getProperty("url");
		String un=System.getProperty("UN");
		
		System.out.println("Env Data=>URL=>"+url);
		System.out.println("user Data=>URL=>"+un);
		
		
	}
}
