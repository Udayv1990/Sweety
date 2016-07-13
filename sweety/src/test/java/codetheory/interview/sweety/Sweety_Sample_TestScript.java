package codetheory.interview.sweety;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import codetheory.interview.sweety.CommonFunctions.DateManipulation;
import codetheory.interview.sweety.CommonFunctions.InvokeApplication;
import codetheory.interview.sweety.CommonFunctions.Wait;
import codetheory.interview.sweety.InputDataMap.AddLevels;
import codetheory.interview.sweety.InputDataMap.AddLevels_DataMap;
import codetheory.interview.sweety.UI.CommonMenu;
import codetheory.interview.sweety.UI.Home;
import codetheory.interview.sweety.UI.LevelEntries;
import codetheory.interview.sweety.UI.Login;
import codetheory.interview.sweety.UI.Reports;

/*
 *
Here are some instructions and next steps.

    Application login: http://damp-sands-8561.herokuapp.com/  
    Use your own email and codetheoryio as password to login
    
    Setup automation scripts for sample test cases for the scenarios you have mentioned.
        1. I would propose to focus on at least 1 test case completeness
        2. Test case must cover at least one instance of Login, Entry, Report
    Upload code to github and share me link.  Please send instruction 
    to run your test case.

Please get back to us latest by Jul 13th.  There are few features in the test cases that don't match with the application we have.  Use whatever features implemented to update your test cases and automate.  

As additional bonus,  please identify the gaps in the application vis-a-vis the application requirement that were sent out to you.  

 */
public class Sweety_Sample_TestScript {

  @Test(priority=1)
  @Parameters({"Username", "Password"})
  public void LoginIntoApp(String Username, String Password) {
	  Login login = new Login();
	  login.getLogin_ID().sendKeys(Username);
	  login.getPassword_ID().sendKeys(Password);
	  Home home = login.LoginToApp();
	  Assert.assertTrue(home.getWelcome_Xpath().getText().toString().contains(Username), "Username displayed in Home page");
	  
  }
  
  @Test(priority=3)
  public void Add_LessThanThree_LevelValues_PerDay(){
	  String testScriptID = "TS_001";
	  AddAndVerifyLevelValues(testScriptID);
  }
  @Test(priority=5)
  public void Add_Four_LevelValues_PerDay(){
	  String testScriptID = "TS_002";
	  AddAndVerifyLevelValues(testScriptID);
  }
  
  public void AddAndVerifyLevelValues(String testScriptID){
	  ArrayList<AddLevels> addLevelsData = AddLevels_DataMap.getAddLevelsDataMap().get(testScriptID);
	  CommonMenu commonMenu = new CommonMenu();
	  LevelEntries levelEntries = commonMenu.navigateToLevelEntryHome();
	  
	  for (AddLevels addLevels : addLevelsData) {
		  levelEntries.getAddNew_LinkText().click();
		  Select select = null;
		  select = new Select(levelEntries.getRecordedAtYear_ID());
		  select.selectByVisibleText(DateManipulation.getYear(addLevels.getStrDate()));

		  select = new Select(levelEntries.getRecordedAtMonth_ID());
		  select.selectByVisibleText(DateManipulation.getMonth(addLevels.getStrDate()));
		  
		  select = new Select(levelEntries.getRecordedAtDate_ID());
		  select.selectByVisibleText(DateManipulation.getDay(addLevels.getStrDate()));
		  
		  select = new Select(levelEntries.getRecordedAtHours_ID());
		  select.selectByVisibleText(DateManipulation.getHours(addLevels.getStrTime()));
		  
		  select = new Select(levelEntries.getRecordedAtMinutes_ID());
		  select.selectByVisibleText(DateManipulation.getMinutes(addLevels.getStrTime()));
		  
		  levelEntries.getLevel_ID().sendKeys(addLevels.getStrLevel());
		  levelEntries.getSubmit_Xpath().click();
		  Wait.ThreadSleepFor(3000);
		  
		  List<WebElement> rows = levelEntries.getRecentEntries_Table().findElements(By.tagName("tr"));
		  String recordValue=null;
		  Boolean recordFlag=false;
		  for (WebElement webElement : rows) {
			  recordValue = webElement.findElement(By.tagName("th")).getText();
			  System.out.println(recordValue);
			  if (recordValue.equalsIgnoreCase(DateManipulation.getFormatedDate(addLevels.getStrDate())+ " @ "+DateManipulation.getTime(addLevels.getStrTime()))) {
				  recordFlag=true;
				  Assert.assertEquals(webElement.findElement(By.tagName("td")).getText().trim(), addLevels.getStrLevel()+" mg/dl");
				break;
			}
		}
		  if (!(recordFlag)) {
		Assert.assertTrue(recordFlag, "Record Not Exist");	
		}
	}
  }
  
  @Test(priority = 4)
  public void VerifyMonthlyReportData(){
	  String testScriptID = "TS_001";
	  verifyMontlyReport(testScriptID);
  }
  
  @Test(priority = 6)
  public void VerifyMonthlyReportDataForOddValues(){
	  String testScriptID = "TS_002";
	  verifyMontlyReport(testScriptID);
  }
  
  public void verifyMontlyReport(String testScriptID){
	  String YearAndMonth = null;
	  String tmpYearAndMonth = null;
	  HashMap<String, ArrayList<AddLevels>> groupDateLevel = new HashMap<String, ArrayList<AddLevels>>();
	  
	  
	  Set<String> AllKeys = AddLevels_DataMap.getAddLevelsDataMap().keySet();
	for (String strKey : AllKeys) {
		ArrayList<AddLevels> addLevelsData = AddLevels_DataMap.getAddLevelsDataMap().get(strKey);
		  for (AddLevels addLevels : addLevelsData) {
			  YearAndMonth = DateManipulation.getYearAndMonth(addLevels.getStrDate());
				if (groupDateLevel.containsKey(YearAndMonth)) {
					groupDateLevel.get(YearAndMonth).add(addLevels);
				}else {
					ArrayList<AddLevels> arrayList = new ArrayList<AddLevels>();
					arrayList.add(addLevels);
					groupDateLevel.put(YearAndMonth, arrayList);
				}
		}
	}
	  
	  
	  

	  CommonMenu commonMenu = new CommonMenu();
	  Reports reports = commonMenu.navigateToLevelReportsHome();
	  
	  reports.getMontlyReport_LinkText().click();
	  Wait.ThreadSleepFor(7000);
	  
	  List<WebElement> tblRows = reports.getReportsTbl_Xpath().findElements(By.tagName("tr"));
	  for (WebElement webElement : tblRows) {
		List<WebElement> tblColumns = webElement.findElements(By.tagName("td"));
		if (tblColumns.size()<1) {
			continue;
		}
		tmpYearAndMonth = tblColumns.get(0).getText().trim();
		if (groupDateLevel.containsKey(tmpYearAndMonth)) {
			int[] varMinMaxAvg = getMinMaxAvg(groupDateLevel.get(tmpYearAndMonth));
		   Assert.assertEquals(Integer.parseInt(tblColumns.get(3).getText().trim()), varMinMaxAvg[0]);
		   Assert.assertEquals(Integer.parseInt(tblColumns.get(4).getText().trim()), varMinMaxAvg[1]);
		   Assert.assertEquals(Double.parseDouble(tblColumns.get(5).getText().trim()), (double)(varMinMaxAvg[2]/varMinMaxAvg[3]));
		}
	}

  }
  
  public int[] getMinMaxAvg(ArrayList<AddLevels> tmpAddLevels) {
	int[] tmpValue = new int[4];
	int sum=0;
	ArrayList<Integer> tmpLevelValues = new ArrayList<Integer>();
	for (AddLevels localAddLevels : tmpAddLevels) {
		tmpLevelValues.add(Integer.parseInt(localAddLevels.getStrLevel()));
	}
	Collections.sort(tmpLevelValues);
	  tmpValue[0] = tmpLevelValues.get(0);
	  tmpValue[1] = tmpLevelValues.get(tmpLevelValues.size()-1);
	  for (Integer integer : tmpLevelValues) {
		  sum = sum + integer;
	}
	  tmpValue[2] = sum;
	  tmpValue[3] = tmpLevelValues.size();
	  return tmpValue;
}
  
  
  
  
  
  @Test(priority=2)
  public void DeleteAllRecentEntries(){
	  CommonMenu commonMenu = new CommonMenu();
	  commonMenu.getLevels_Xpath().click();
	  Wait.ThreadSleepFor(10000);
	  
	  LevelEntries levelEntries = new LevelEntries();
//	  Wait.WaitTillPageLoad(levelEntries.getRecentEntries_Table());
	  List<WebElement> eleRow = levelEntries.getRecentEntriesDeleteLinks();
	  for (int i=0; i<eleRow.size(); i++) {
		  List<WebElement> objDeleteEle = levelEntries.getRecentEntriesDeleteLinks();
		  objDeleteEle.get(0).click();
		  Wait.WaitTillAlertPresent();
		  InvokeApplication.getDriver().switchTo().alert().accept();
		  Wait.ThreadSleepFor(3000);
	}
  }
 
}
