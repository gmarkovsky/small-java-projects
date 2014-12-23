package com.gmail.gbmarkosky.skud.engine;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public final class Calculator {
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
			
			if (!cur.isEmpty())
				week = Evaluator.add(week, cur);
			
			if (i == 0 || header[i].contains("Пн")) {
				worker.putWeek(header[i], week);
				total = Evaluator.add(total, week);
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
					worker.putMark(key, Evaluator.toDuration(value));
				} else if (ERROR.matcher(value).matches()) {
					worker.putMark(key, "?");
				} else {
					worker.putMark(key, value);
				}
		}
	}
}