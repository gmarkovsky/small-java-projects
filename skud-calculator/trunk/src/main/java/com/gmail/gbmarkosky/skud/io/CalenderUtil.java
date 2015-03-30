package com.gmail.gbmarkosky.skud.io;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalenderUtil {
	private static final String[] WEEK_DAYS = new String[] {"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"};
	
	private int startDay;
	private int daysCount;

	private CalenderUtil() {
		
	}
	
	public int getStartDay() {
		return startDay;
	}
	
	public int getDaysCount() {
		return daysCount;
	}
	
	private void initialize(int year, int month) {
		int iMonth = month - 1;
		int iDay = 1;

		Calendar mycal = new GregorianCalendar(year, iMonth, iDay);

		daysCount = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		startDay = mycal.get(Calendar.DAY_OF_WEEK) - 1;
		
		if (startDay == 0)
			startDay = 7;
	}
	
	public static CalenderUtil create(int year, int month) {
		CalenderUtil util = new CalenderUtil();
		util.initialize(year, month);
		return util;
	}
	
	public static int dayNumber(String cell) {
		for (int i = 0; i < WEEK_DAYS.length; i++) {
			if (cell.contains(WEEK_DAYS[i]))
				return i + 1; 
		}
		
		return -1;
	}
}
