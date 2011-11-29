package com.gmail.gbmarkovsky.es.util;

public class Profiler {
	private static long snapshot;
	private static boolean started;
	
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
}
