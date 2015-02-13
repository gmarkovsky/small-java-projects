package com.gmail.gbmarkosky.skud.engine;

import org.junit.Assert;
import org.junit.Test;

public class WorkerTest {
	@Test
	public void test() {
		Worker worker = Worker.fromString(";;;08:00;06:00;;;;", 7, ";");
		Assert.assertEquals(7, worker.getMarks().size());
	}
}
