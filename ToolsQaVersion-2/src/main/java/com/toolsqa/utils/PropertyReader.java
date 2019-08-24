package com.toolsqa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.toolsqa.constants.Constants;

public class PropertyReader {
	private static PropertyReader propReader;
	private Properties prop;
	
	//loads all files
	private PropertyReader() {
		List<String> propsFiles = Arrays.asList(Constants.XPATH_FILE,Constants.Test_Data);
		prop = new Properties();
		
		for (String filePath : propsFiles) {
			try {
				prop.load(new FileInputStream(new File(filePath)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		  public static PropertyReader getInstance()
	  { 
		  if(propReader == null)
	 propReader = new PropertyReader();
	  return propReader;
	  }
	public String getValue(String key) {
		return prop.getProperty(key);
	}
	
public static void main(String[] args) {
	String s=propReader.getValue("clickTogglePass");
	System.out.println(s);
	
}


}
