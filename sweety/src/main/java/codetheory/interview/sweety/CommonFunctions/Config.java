package codetheory.interview.sweety.CommonFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class Config {
	private static HashMap<String, String> configValues = new HashMap<String, String>();
	
	public static void LoadConfigData() {
		
		try {
			File file = new File(SetFrameWorkParameters.getProperties()+"Config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration<Object> enuKeys = properties.keys();
			
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				
//				System.out.println(key + ": " + value);
				if (key.equals("") || key == null) {
					continue;
				}
				configValues.put(key, value);
//				System.out.println(key + ": " + value);
			}
			
		} catch(FileNotFoundException e){
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String BrowserType() {
		if(configValues.isEmpty()) LoadConfigData();
		if (!(configValues.containsKey("Browser_Type"))) {
//			System.out.println("Config file not contain Browser_Type");
			System.exit(0);
		}
		return configValues.get("Browser_Type");
	}
	
	public static int DefaultCounter() {
		if(configValues.isEmpty()) LoadConfigData();
		if (!(configValues.containsKey("DefaultCounter"))) {
//			System.out.println("Config file not contain DefaultCounter");
			configValues.put("DefaultCounter", "25");
		}
		return Integer.parseInt(configValues.get("DefaultCounter"));
	}
	
	public static int Min_Counter() {
		if(configValues.isEmpty()) LoadConfigData();
		if (!(configValues.containsKey("Min_Counter"))) {
//			System.out.println("Config file not contain Min_Counter");
			configValues.put("Min_Counter", "10");
		}
		return Integer.parseInt(configValues.get("Min_Counter"));
	}
	
	public static int Normal_Counter() {
		if(configValues.isEmpty()) LoadConfigData();
		if (!(configValues.containsKey("Normal_Counter"))) {
//			System.out.println("Config file not contain Normal_Counter");
			configValues.put("Normal_Counter", "40");
		}
		return Integer.parseInt(configValues.get("Normal_Counter"));
	}
	
	public static int Max_Counter() {
		if(configValues.isEmpty()) LoadConfigData();
		if (!(configValues.containsKey("Max_Counter"))) {
//			System.out.println("Config file not contain Max_Counter");
			configValues.put("Max_Counter", "60");
		}
		return Integer.parseInt(configValues.get("Max_Counter"));
	}
	
	public static String InputDataSet() {
		if(configValues.isEmpty()) LoadConfigData();
		if (!(configValues.containsKey("InputDataSet"))) {
//			System.out.println("Config file not contain InputDataSet");
			configValues.put("InputDataSet", "ie");
		}
		return configValues.get("InputDataSet");
	}
	
	
	public static String getDefaultAppURL() {
		if(configValues.isEmpty()) LoadConfigData();
		if (!(configValues.containsKey("URL"))) {
//			System.out.println("Config file not contain InputDataSet");
			configValues.put("URL", "http://www.google.com");
		}
		return configValues.get("URL");
	}
	
	

}
