package com.hrm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility
{
	public String getDataFromJsonFile(String key) throws IOException, ParseException
	{
		//read data from properties file
        JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./configAppData/appCommonData.json"));
		JSONObject map=(JSONObject)obj;
		String data=map.get("url").toString();
		return data;
	}

}
