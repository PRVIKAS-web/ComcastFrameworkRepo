package practice.basics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class JavaBasics {

	public static void main(String[] args) 
	{
		Date dateobj=new Date();
		
		System.out.println(dateobj.toString());
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String act=sim.format(dateobj);
		System.out.println(act);
		
		SimpleDateFormat sim1=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=sim1.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String req=sim1.format(cal.getTime());
		System.out.println(req);
		
		
		
	}

}
