package practice.datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		JSONParser parser=new JSONParser();
		
		Object obj=parser.parse(new FileReader("C:\\Users\\VRCR\\OneDrive\\Desktop\\appCommonData.json"));

		JSONObject map=(JSONObject)obj;
		
		map.get("url");
		System.out.println(map.get("url") );
	}

}
