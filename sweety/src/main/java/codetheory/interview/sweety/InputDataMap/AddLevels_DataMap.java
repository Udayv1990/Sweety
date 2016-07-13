package codetheory.interview.sweety.InputDataMap;

import java.util.ArrayList;
import java.util.HashMap;

import codetheory.interview.sweety.CommonFunctions.Excel;
import codetheory.interview.sweety.CommonFunctions.SetFrameWorkParameters;

public class AddLevels_DataMap {
private static HashMap<String, ArrayList<AddLevels>> addLevelsDataMap = new HashMap<String, ArrayList<AddLevels>>();

public static HashMap<String, ArrayList<AddLevels>> getAddLevelsDataMap() {
	if (addLevelsDataMap.isEmpty()) {
		addLevelsDataMap = Excel.getSweetyTestData(SetFrameWorkParameters.getInputData()+"Sweety.xls","AddLevel");
	}
	return addLevelsDataMap;
}
}
