package com.gmail.gbmarkosky.skud.engine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Worker {
	private final String name;
	private final Map<Integer, Duration> marks = new HashMap<Integer, Duration>();
	private final Map<Integer, Duration> marksView = Collections.unmodifiableMap(marks);
	
	private final Map<Integer, Duration> week = new HashMap<Integer, Duration>();
	private final Map<Integer, Duration> weekView = Collections.unmodifiableMap(week);
	
	private Duration total;
	private String line;
	private String line2;
	private String line3;
	
	private Worker(String name) {
		this.name = name;
	}
	
	public void putMark(Integer key, Duration val) {
		marks.put(key, val);
	}
	
	public Map<Integer, Duration> getMarks() {
		return marksView;
	}

	public void putWeek(Integer key, Duration val) {
		week.put(key, val);
	}
	
	public Map<Integer, Duration> getWeeks() {
		return weekView;
	}
	
	public Duration getTotal() {
		return total;
	}

	public void setTotal(Duration total) {
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
	
	public static Worker fromString(String s, int startDay, int daysCount, String separator) {
		String[] split = s.split(separator);
		
		Worker worker = new Worker(split[0]);
		
		Duration week = Duration.zero();
		Duration total = Duration.zero();
		
		for (int i = daysCount; i >= 1; i--) {
			int withOffset = i + 2;
			String value = (withOffset < split.length) ? split[withOffset] : "";
			
			
			Duration duration = null;
			
			if (!value.isEmpty())
				if (INTERVAL.matcher(value).matches()) {
					duration = Duration.parseDuration(value);
					
				} else if (ERROR.matcher(value).matches()) {
					duration = Duration.open();
				}
			
			
			if (duration != null) {
				week.add(duration);
				worker.putMark(i, duration);
			}
			
			if (i == 1 || (i - 1 + (startDay - 1)) % 7 == 0) {
				worker.putWeek(i, week);
				total.add(week);
				week = Duration.zero();
			}
		}
		worker.setTotal(total);
		return worker;
	}
	
	private static final Pattern INTERVAL = Pattern.compile("\\d\\d:\\d\\d-\\d\\d:\\d\\d");
	private static final Pattern ERROR = Pattern.compile("Н-\\d\\d:\\d\\d|\\d\\d:\\d\\d-Н");

}
