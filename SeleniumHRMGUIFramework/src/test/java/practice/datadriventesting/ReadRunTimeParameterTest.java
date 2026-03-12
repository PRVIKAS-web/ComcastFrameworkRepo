package practice.datadriventesting;

import org.junit.Test;

public class ReadRunTimeParameterTest {

	@Test
	public static void main(String[] args) 
	{
		System.out.println(args.length);
       for(String var:args)
       {
    	   System.out.println(var);
       }

	}

}
