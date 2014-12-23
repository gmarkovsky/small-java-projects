package com.gmail.gbmarkosky.skud;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Calculator {
	private static final Pattern DD = Pattern.compile("(\\d\\d)");
	private static final Pattern INTERVAL = Pattern.compile("\\d\\d:\\d\\d-\\d\\d:\\d\\d");
	private static final Pattern ERROR = Pattern.compile("Н-\\d\\d:\\d\\d|\\d\\d:\\d\\d-Н");
	
	private Calculator() { }
	
	public static void agregate(String[] header, Worker worker) {
		prepare(worker);
		
		Map<String, String> marks = worker.getMarks();
		String week = "";
		String total = "";
		for (int i = header.length - 1; i >= 0 ; i--) {
			String cur = marks.get(header[i]);
			String next = (i > 0) ? marks.get(header[i-1]) : "";
			
			if (!cur.isEmpty())
				week = add(week, cur);
			
			if ((next.isEmpty() && !cur.isEmpty() && !week.isEmpty()) || i == 0) {
				worker.putWeek(header[i], week);
				total = add(total, week);
				week = "";
			}
		}
		worker.setTotal(total);
	}
	
	private static void prepare(Worker worker) {
		Map<String, String> marks = worker.getMarks();
		
		for (Entry<String, String> entry : marks.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (!value.isEmpty())
				if (INTERVAL.matcher(value).matches()) {
					worker.putMark(key, evaluateDuration(value));
				} else if (ERROR.matcher(value).matches()) {
					worker.putMark(key, "?");
				} else {
					worker.putMark(key, value);
				}
		}
	}
	
	private static String evaluateDuration(String e) {
		int[] times = toArray(e);
		
		int h = times[2] - times[0];
		int m = times[3] - times[1];
		if (m < 0) {
			m += 60;
			h--;
		}
		
		return String.format("%02d:%02d", h, m);
	}
	
	private static String add(String a, String b) {
		String suff = (a.contains("?") || b.contains("?")) ? "+?" : "";
		if (a.isEmpty())
			return addReal("00:00", b) + suff;
		else 
			return addReal(a, b) + suff;
	}
	
	private static String addReal(String a, String b) {
		int[] times = toArray(a+" "+b);
		int h = times[2] + times[0];
		int m = times[3] + times[1];
		if (m > 59) {
			m -= 60;
			h++;
		}
		
		return String.format("%02d:%02d", h, m);
	}
	
	private static int[] toArray(String s) {
		Matcher matcher = DD.matcher(s);
		int i = 0;
		int[] times = new int[4];
		while (matcher.find() && i < 4) {
			times[i] = Integer.parseInt(matcher.group());
			i++;
		}
		return times;
	}
}
