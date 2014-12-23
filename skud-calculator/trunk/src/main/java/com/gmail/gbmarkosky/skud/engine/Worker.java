package com.gmail.gbmarkosky.skud.engine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Worker {
	private final String name;
	private final Map<String, String> marks = new HashMap<String, String>();
	private final Map<String, String> marksView = Collections.unmodifiableMap(marks);
	
	private final Map<String, String> week = new HashMap<String, String>();
	private final Map<String, String> weekView = Collections.unmodifiableMap(week);
	
	private String total;
	private String line;
	private String line2;
	private String line3;
	
	private Worker(String name) {
		this.name = name;
	}
	
	public void putMark(String key, String val) {
		marks.put(key, val);
	}
	
	public Map<String, String> getMarks() {
		return marksView;
	}

	public void putWeek(String key, String val) {
		week.put(key, val);
	}
	
	public Map<String, String> getWeeks() {
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
	
	public static Worker fromString(String s, String[] header) {
		String[] split = s.split(";");
		
		Worker worker = new Worker(split[0]);
		
		for (int i = 0; i < header.length; i++) {
			String val = (i + 3 < split.length) ? split[i+3] : "";
			worker.putMark(header[i], val);
		}
		
		return worker;
	}
}
