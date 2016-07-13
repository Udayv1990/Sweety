package codetheory.interview.sweety.CommonFunctions;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DateManipulation {
	
//	@Test
//	public void f(){
//		System.out.println(getYear("7/3/2016"));
//		System.out.println(getYearAndMonth("7/3/2015"));
////		System.out.println(getTime("15:46"));
//	}
	
	public static Date getDate(String strDate) {
		SimpleDateFormat format1 = new SimpleDateFormat("M/d/yy");
		try {
			return format1.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getFormatedDate(String strDate) {
		String formatedDate=null;
		SimpleDateFormat format1 = new SimpleDateFormat("M/d/yy");
			try {
				formatedDate = format1.format(format1.parse(strDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return formatedDate;
	}
	// for monthly report
	public static String getYearAndMonth(String strDate) {
		String formatedDate=null;
		Calendar cal = Calendar.getInstance();
				cal.setTime(getDate(strDate));
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MMM");
			formatedDate = format1.format(cal.getTime());
		return formatedDate;
	}
	
	public static Date FormatedTime(String strTime) {
		Date date = null;
		SimpleDateFormat format1 = new SimpleDateFormat("HH:mm");
		try {
			date = format1.parse(strTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String getMonth(String strDate) {
		Calendar cal = Calendar.getInstance();
//		System.out.println(getDate(strDate));
		return getMonthNameForInt(cal.get(Calendar.MONTH));
	}
	
	public static String getYear(String strDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getDate(strDate));
		return Integer.toString(cal.get(Calendar.YEAR));
	}
	
	public static String getDay(String strDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getDate(strDate));
		return Integer.toString(cal.get(Calendar.DATE));
	}
	
	public static String getHours(String strTime) {
		String strHours = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(FormatedTime(strTime));
		if(cal.get(Calendar.HOUR_OF_DAY)<10){
			strHours ="0"+cal.get(Calendar.HOUR_OF_DAY);
			}else{
			strHours = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
			}
		return strHours;
	}
	
	public static String getMinutes(String strTime) {
		String strMinutes = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(FormatedTime(strTime));
		if(cal.get(Calendar.MINUTE)<10){
			strMinutes ="0"+cal.get(Calendar.MINUTE);
			}else{
			strMinutes = Integer.toString(cal.get(Calendar.MINUTE));
			}
		return strMinutes;
	}
	
	
	
	public static String getMonthNameForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
    }
	
	//for report perpose 
	public static String getTime(String strTime){
		String date = null;
		SimpleDateFormat format1 = new SimpleDateFormat("h:mm a");
		date = format1.format(FormatedTime(strTime));
		return date;
	}

}
