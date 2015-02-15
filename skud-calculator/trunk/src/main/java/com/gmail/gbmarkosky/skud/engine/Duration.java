package com.gmail.gbmarkosky.skud.engine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Duration {
	private static final Pattern DD = Pattern.compile("(\\d{2,})");
	
	private int hours;
	private int minutes;
	
	private boolean open;
	
	public Duration(int hours, int minutes, boolean open) {
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.open = open;
	}

	public void add(Duration d) {
		this.hours += d.hours;
		this.minutes += d.minutes;
		this.open = this.open || d.open;
		
		if (this.minutes > 59) {
			this.minutes -= 60;
			this.hours++;
		}
	}
	
	public static Duration parseDuration(String s) {
		Matcher matcher = DD.matcher(s);
		int i = 0;
		int[] times = new int[4];
		while (matcher.find() && i < 4) {
			times[i] = Integer.parseInt(matcher.group());
			i++;
		}
		
		int h = times[2] - times[0];
		int m = times[3] - times[1];
		if (m < 0) {
			m += 60;
			h--;
		}
		
		return new Duration(h, m, false);
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public boolean isOpen() {
		return open;
	}
	
	public static Duration open() {
		return new Duration(0, 0, true);
	}
	
	public static Duration zero() {
		return new Duration(0, 0, false);
	}
	
	@Override
	public String toString() {
		return String.format("%02d:%02d", hours, minutes) + ((open) ? " + ?" : "");
	}
}
