package com.hrm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomnumber=random.nextInt(5000);
		return randomnumber;
	}
	
	public String getSystemDate()
	{
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actualdate=sim.format(date);
		return actualdate;
		
	}
	
	public String getRequiredDateyyyyDDMM(int days)
	{
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqdate=sim.format(cal.getTime());
		return reqdate;
		
	}

}
