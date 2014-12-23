package com.gmail.gbmarkosky.skud.engine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Evaluator {
	private static final Pattern DD = Pattern.compile("(\\d{2,})");
	
	private Evaluator() { }
	
	public static String toDuration(String e) {
		int[] times = toArray(e);
		
		int h = times[2] - times[0];
		int m = times[3] - times[1];
		if (m < 0) {
			m += 60;
			h--;
		}
		
		return String.format("%02d:%02d", h, m);
	}
	
	public static String add(String a, String b) {
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
