package com.hrm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility
{
	public String getDataFromPropertyFile(String key) throws IOException
	{
		//read data from properties file
        FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String data=prop.getProperty(key);
        return data;
	}

}
