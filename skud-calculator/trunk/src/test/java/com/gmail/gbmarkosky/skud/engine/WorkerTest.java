package com.gmail.gbmarkosky.skud.engine;

import org.junit.Assert;
import org.junit.Test;

public class WorkerTest {
	@Test
	public void test() {
		Worker worker = Worker.fromString("Вася;;;09:00-17:30;10:00-12:00;;;;;", 1, 7, ";");
		Assert.assertEquals(2, worker.getMarks().size());
		
		Assert.assertEquals(8, worker.getMarks().get(1).getHours());
		Assert.assertEquals(30, worker.getMarks().get(1).getMinutes());
		
		Assert.assertEquals(2, worker.getMarks().get(2).getHours());
		Assert.assertEquals(0, worker.getMarks().get(2).getMinutes());
		
		Assert.assertEquals(10, worker.getWeeks().get(1).getHours());
		Assert.assertEquals(30, worker.getWeeks().get(1).getMinutes());
		
		Assert.assertEquals(10, worker.getTotal().getHours());
		Assert.assertEquals(30, worker.getTotal().getMinutes());
	}
	
	@Test
	public void test2() {
		Worker worker = Worker.fromString("Вася;;;09:00-17:30;10:00-12:00;10:00-11:00;10:00-11:00;10:00-11:00;;;09:00-17:00;10:00-12:00;10:00-11:00;10:00-11:00;10:00-11:00", 1, 14, ";");
		Assert.assertEquals(10, worker.getMarks().size());
		
		Assert.assertEquals(8, worker.getMarks().get(1).getHours());
		Assert.assertEquals(30, worker.getMarks().get(1).getMinutes());
		
		Assert.assertEquals(2, worker.getMarks().get(2).getHours());
		Assert.assertEquals(0, worker.getMarks().get(2).getMinutes());
		
		Assert.assertEquals(13, worker.getWeeks().get(1).getHours());
		Assert.assertEquals(30, worker.getWeeks().get(1).getMinutes());
		
		Assert.assertEquals(13, worker.getWeeks().get(8).getHours());
		Assert.assertEquals(0, worker.getWeeks().get(8).getMinutes());
		
		Assert.assertEquals(26, worker.getTotal().getHours());
		Assert.assertEquals(30, worker.getTotal().getMinutes());
	}
	
	@Test
	public void test3() {
		Worker worker = Worker.fromString("Вася;;;;09:00-17:30;10:00-12:00;10:00-11:00;10:00-11:00;10:00-11:00;;;09:00-17:00;10:00-12:00;10:00-11:00;10:00-11:00;10:00-11:00", 7, 14, ";");
		Assert.assertEquals(10, worker.getMarks().size());
		
		Assert.assertEquals(8, worker.getMarks().get(2).getHours());
		Assert.assertEquals(30, worker.getMarks().get(2).getMinutes());
		
		Assert.assertEquals(2, worker.getMarks().get(3).getHours());
		Assert.assertEquals(0, worker.getMarks().get(3).getMinutes());
		
		Assert.assertEquals(13, worker.getWeeks().get(2).getHours());
		Assert.assertEquals(30, worker.getWeeks().get(2).getMinutes());
		
		Assert.assertEquals(13, worker.getWeeks().get(9).getHours());
		Assert.assertEquals(0, worker.getWeeks().get(9).getMinutes());
		
		Assert.assertEquals(26, worker.getTotal().getHours());
		Assert.assertEquals(30, worker.getTotal().getMinutes());
	}
}
