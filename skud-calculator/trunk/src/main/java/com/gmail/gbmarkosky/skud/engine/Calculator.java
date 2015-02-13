package com.gmail.gbmarkosky.skud.engine;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public final class Calculator {
	private static final Pattern INTERVAL = Pattern.compile("\\d\\d:\\d\\d-\\d\\d:\\d\\d");
	private static final Pattern ERROR = Pattern.compile("Н-\\d\\d:\\d\\d|\\d\\d:\\d\\d-Н");
	
	private Calculator() { }
	
	public static void agregate(int startDay, int daysCount, Worker worker) {
		prepare(worker);
		
		Map<Integer, String> marks = worker.getMarks();
		String week = "";
		String total = "";
		for (int i = daysCount; i >= 1; i--) {
			String cur = marks.get(i);
			
			if (!cur.isEmpty())
				week = Evaluator.add(week, cur);
			
			if (i == 1 || (i + 1 + startDay + daysCount / 7) % 7 == 0) {
				worker.putWeek(i, week);
				total = Evaluator.add(total, week);
				week = "";
			}
		}
		worker.setTotal(total);
	}
	
	private static void prepare(Worker worker) {
		Map<Integer, String> marks = worker.getMarks();
		
		for (Entry<Integer, String> entry : marks.entrySet()) {
			Integer key = entry.getKey();
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