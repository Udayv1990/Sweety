package codetheory.interview.sweety.CommonFunctions;

import java.io.File;

public class SetFrameWorkParameters {
	private static  String absolutePath;
	private static  String Properties;
	private static  String InputData;
	private static  String SupportingFilesAndJars;
	private static  String Results;
	private static  String ObjectRepository;
		
	/*private SetFrameWorkParameters()
	{
		// To prevent external instantiation of this class
	}
	
	*/
	
	public static void main(String[] args) {
		
		if (absolutePath==null) {
			SetAbsolutePath();
			System.out.println(absolutePath);
			
		}
	}
	

	/**
	 * Function to get the separator string to be used for directories and files based on the current OS
	 * @return The file separator string
	 */
	public static String getFileSeparator()
	{
		return System.getProperty("file.separator");
	}
	
	
/** 
 *  To Set Folder Path in Frame Work	
 */
	public static void setProperties() {
		if (absolutePath==null) SetAbsolutePath();
		SetFrameWorkParameters.Properties = absolutePath + "Properties" + getFileSeparator();
	}
	public static String getProperties() {
		if (Properties == null) setProperties();
		return Properties;
	}
	

	public static void setInputData() {
		if (absolutePath==null) SetAbsolutePath();
		SetFrameWorkParameters.InputData = absolutePath + "InputData" + getFileSeparator();
	}
	public static String getInputData() {
		if (InputData == null) setInputData();
		return InputData;
	}
	
	
	
	public static void setSupportingFilesAndJars() {
		if (absolutePath==null) SetAbsolutePath();
		SetFrameWorkParameters.SupportingFilesAndJars = absolutePath + "DriverServers" + getFileSeparator();
	}
	public static String getLibPath() {
		if (SupportingFilesAndJars == null) setSupportingFilesAndJars();
		return SupportingFilesAndJars;
	}
	
	
	public static String getResults() {
		if (Results == null) setResults();
		return Results;
	}
	public static void setResults() {
		if (absolutePath==null) SetAbsolutePath();
		SetFrameWorkParameters.Results = absolutePath + "Results" + getFileSeparator();
	}
	
	
	public static String getObjectRepository() {
		if (ObjectRepository==null) setObjectRepository();
		return ObjectRepository;
	}
	public static void setObjectRepository() {
		if (absolutePath==null) SetAbsolutePath();
		SetFrameWorkParameters.ObjectRepository = absolutePath + "src" + getFileSeparator()+"objectRepository" + getFileSeparator();
	}
	
	
	public static void SetAbsolutePath(){
		SetFrameWorkParameters.absolutePath = new File(System.getProperty("user.dir")).getAbsolutePath() + getFileSeparator()  ;
	}
	public static String getAbsolutePath() {
		if (absolutePath==null) SetAbsolutePath();
		return absolutePath;
	}
	

/**
 * Set Config Variables
 * 
 */
	
	
	
	

}
