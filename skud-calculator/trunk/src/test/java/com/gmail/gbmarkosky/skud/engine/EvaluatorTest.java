package com.gmail.gbmarkosky.skud.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvaluatorTest {
	@Test
	public void testDuration() {
		assertEquals("00:15", Evaluator.toDuration("10:00-10:15"));
		assertEquals("10:15", Evaluator.toDuration("00:00-10:15"));
		assertEquals("00:00", Evaluator.toDuration("10:00-10:00"));
		assertEquals("00:55", Evaluator.toDuration("01:20-02:15"));
	}
	
	@Test
	public void testAdd() {
		assertEquals("07:00", Evaluator.add("06:45", "00:15"));
		assertEquals("121:25", Evaluator.add("55:10", "66:15"));
		assertEquals("06:45+?", Evaluator.add("06:45", "?"));
		assertEquals("07:00+?", Evaluator.add("06:45", "00:15+?"));
		assertEquals("07:00+?", Evaluator.add("06:45+?", "00:15"));
		assertEquals("06:45", Evaluator.add("06:45", ""));
		assertEquals("06:45", Evaluator.add("", "06:45"));
		assertEquals("00:00", Evaluator.add("", ""));
		assertEquals("00:00+?", Evaluator.add("", "?"));
	}
}
