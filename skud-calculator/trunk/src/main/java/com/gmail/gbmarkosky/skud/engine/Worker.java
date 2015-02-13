package com.gmail.gbmarkosky.skud.engine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Worker {
	private final String name;
	private final Map<Integer, String> marks = new HashMap<Integer, String>();
	private final Map<Integer, String> marksView = Collections.unmodifiableMap(marks);
	
	private final Map<Integer, String> week = new HashMap<Integer, String>();
	private final Map<Integer, String> weekView = Collections.unmodifiableMap(week);
	
	private String total;
	private String line;
	private String line2;
	private String line3;
	
	private Worker(String name) {
		this.name = name;
	}
	
	public void putMark(Integer key, String val) {
		marks.put(key, val);
	}
	
	public Map<Integer, String> getMarks() {
		return marksView;
	}

	public void putWeek(Integer key, String val) {
		week.put(key, val);
	}
	
	public Map<Integer, String> getWeeks() {
		return weekView;
	}
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}
	
	public static Worker fromString(String s, int daysCount, String separator) {
		String[] split = s.split(separator);
		
		Worker worker = new Worker(split[0]);
		
		for (int i = 1; i <= daysCount; i++) {
			int withOffset = i + 2;
			String val = (withOffset < split.length) ? split[withOffset] : "";
			worker.putMark(i, val);
		}
		
		return worker;
	}
}
