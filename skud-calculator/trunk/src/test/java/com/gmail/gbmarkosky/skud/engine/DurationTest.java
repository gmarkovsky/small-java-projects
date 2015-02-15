package com.gmail.gbmarkosky.skud.engine;



import org.junit.Assert;
import org.junit.Test;

public class DurationTest {

	@Test
	public void test() {
		
		Duration duration = Duration.parseDuration("10:55-11:50");
		
		Assert.assertEquals(0, duration.getHours());
		Assert.assertEquals(55, duration.getMinutes());
		Assert.assertFalse(duration.isOpen());
		
	}

}
