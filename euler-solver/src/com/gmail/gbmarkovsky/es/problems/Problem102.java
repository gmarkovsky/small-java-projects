package com.gmail.gbmarkovsky.es.problems;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.StringTokenizer;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.google.common.io.Files;

public class Problem102 implements EulerProblem {

	private final String file;

	public Problem102(String input) {
		this.file = input;
	}

	@Override
	public String solve() {
		readTriangle(file);
		
		return "unsolved";
	}

	void readTriangle(String filePath) {
		List<String> lines = null;
		try {
			lines = Files.readLines(new File(filePath),
					Charset.defaultCharset());
		} catch (IOException e) {
			System.err.println("Input data file not found!");
		}
		
		lines.size();
		
		for (String string : lines) {
			String[] split = string.split(",");
		}
	}
	
	public static void main(String[] args) {
		Problem102 problem102 = new Problem102("res/102.txt");
		problem102.solve();
	}
}
