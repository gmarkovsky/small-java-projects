package com.gmail.gbmarkovsky.es.util;

public class Profiler {
	private static long snapshot;
	private static long bigSnapshot;
	private static boolean started;
	
	public static void bigStart() {
		bigSnapshot = System.currentTimeMillis();
	}
	
	public static void start() {
		snapshot = System.currentTimeMillis();
		started = true;
	}
	
	public static double finish() {
		long current = System.currentTimeMillis() - snapshot;
		if (!started) {
			throw new RuntimeException("Profiler don't started");
		}
		started = false;
		return ((double) current) / 1000d;
	}
	
	public static double bigFinish() {
		long current = System.currentTimeMillis() - bigSnapshot;
		return ((double) current) / 1000d;
	}
}
