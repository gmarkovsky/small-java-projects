package com.gmail.gbmarkovsky.es.problems;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class Problem22 implements EulerProblem {
	@Override
	public String solve() {
		List<String> read = read();
		Collections.sort(read, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		int c = 1;
		long res = 0;
		for (String string : read) {
			res += c * score(string);
			c++;
		}
		return Long.toString(res);
	}
	
	List<String> read() {
		List<String> result = Lists.newArrayList();
		String lines = null;
		try {
			lines = Files.toString(new File("res/22.txt"), Charset.defaultCharset());
		} catch (IOException e) {
			System.err.println("Input data file not found!");
		}
			StringTokenizer tokenizer = new StringTokenizer(lines);
			while (tokenizer.hasMoreTokens()) {
				result.add(tokenizer.nextToken("\",\""));
			}
		
		return result;
	}
	
	int score(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			
			result += Character.getNumericValue(s.charAt(i)) - 9;
		}
		return result;
	}
}
