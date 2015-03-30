package com.gmail.gbmarkosky.skud.io;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalenderUtilTest {
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 {2015, 1, 4, 31} , {2015, 2, 7, 28}, {2012, 2, 3, 29}
           });
    }
	
    @Parameter(value = 0)
    public int year;

    @Parameter(value = 1)
    public int month;
    
    @Parameter(value = 2)
    public int startDay;

    @Parameter(value = 3)
    public int daysCount;

    @Test
    public void test() {
    	CalenderUtil create = CalenderUtil.create(year, month);
    	
    	Assert.assertEquals(startDay, create.getStartDay());
    	Assert.assertEquals(daysCount, create.getDaysCount());
    }
}
