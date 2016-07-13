package codetheory.interview.sweety.CommonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import codetheory.interview.sweety.InputDataMap.AddLevels;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel {

		
	public static String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
					System.out.println(arrayExcelData[i-1][j]);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
	public static HashMap<String, ArrayList<AddLevels>> getSweetyTestData(String fileName, String sheetName) {
		AddLevels addLevels=null;
//		ArrayList<AddLevels> addLevelsObject = new ArrayList<AddLevels>();
		HashMap<String, ArrayList<AddLevels>> addLevelsDataObject = new HashMap<String, ArrayList<AddLevels>>();
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);
			
			int headerRow = 0;
			
			//Column Numbers
			int strDate = 0;
			int strTime =0;
			int strLevel=0;
			int strExecuteFlag =0;
			int strTestScriptID=0;

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			for (int k = 0; k < totalNoOfCols; k++) {
				String tmpValue = sh.getCell(k, headerRow).getContents();
			if (tmpValue.equalsIgnoreCase("Date")) {
					strDate = k;
				} else if (tmpValue.equalsIgnoreCase("Time")) {
					strTime = k;				
				} else if (tmpValue.equalsIgnoreCase("Level")) {
					strLevel = k;				
				} else if (tmpValue.equalsIgnoreCase("ExecuteFlag")) {
					strExecuteFlag=k;
				} else if (tmpValue.equalsIgnoreCase("TestScriptID")){
					strTestScriptID=k;
				}
			}
			
			for (int i= 1 ; i < totalNoOfRows; i++) {
				if (sh.getCell(strExecuteFlag, i).getContents().equalsIgnoreCase("Yes")) {
					String testScriptID;
					addLevels = new AddLevels();
					testScriptID = sh.getCell(strTestScriptID, i).getContents();
					addLevels.setStrDate(sh.getCell(strDate, i).getContents());
					addLevels.setStrLevel(sh.getCell(strLevel, i).getContents());
					addLevels.setStrTime(sh.getCell(strTime, i).getContents());
					addLevels.setStrTestScriptID(testScriptID);

					if (addLevelsDataObject.containsKey(testScriptID)) {
						addLevelsDataObject.get(testScriptID).add(addLevels);
					}else {
						ArrayList<AddLevels> arrayList = new ArrayList<AddLevels>();
						arrayList.add(addLevels);
						addLevelsDataObject.put(testScriptID, arrayList);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addLevelsDataObject;
	}

}
