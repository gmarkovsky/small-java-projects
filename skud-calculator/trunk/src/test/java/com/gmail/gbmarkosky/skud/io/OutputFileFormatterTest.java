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
public class OutputFileFormatterTest {
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 {"file.csv", "file-output.csv"},
                 {"file", "file-output.csv"},
                 {"/home/user/file.csv", "/home/user/file-output.csv"},
                 {"/home/user/file", "/home/user/file-output.csv"},
                 {"/home/user/file.csv.csv", "/home/user/file.csv-output.csv"}
           });
    }
	
    @Parameter(value = 0)
    public String input;

    @Parameter(value = 1)
    public String output;
	
	@Test
	public void test() {
		Assert.assertEquals(output, OutputFileFormatter.format(input));
	}
}
