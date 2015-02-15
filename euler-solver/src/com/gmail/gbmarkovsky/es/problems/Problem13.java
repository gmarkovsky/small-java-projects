package com.gmail.gbmarkovsky.es.problems;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.List;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.google.common.collect.Lists;
import com.google.common.io.Files;


public class Problem13 implements EulerProblem {
	
	@Override
	public String solve() {
		List<String> s = readNumber();
		BigInteger result = new BigInteger("0");
		for (String string : s) {
			result = result.add(new BigInteger(string));
		}
		return result.toString().substring(0, 10);
	}
	
	static List<String> readNumber() {
		try {
			return Files.readLines(new File("res/150.txt"), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
			return Lists.newArrayList();
		}
	}
}
