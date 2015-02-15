package com.gmail.gbmarkovsky.es.problems;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.StringTokenizer;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.google.common.io.Files;

public class Problem18 implements EulerProblem {

	private final String file;

	public Problem18(String input) {
		this.file = input;
	}

	@Override
	public String solve() {
		int[][] b = readTriangle(file);
		for (int i = b.length - 2; i >= 0; i--) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = Math.max(b[i + 1][j], b[i + 1][j + 1]) + b[i][j];
			}
		}
		return Integer.toString(b[0][0]);
	}

	int[][] readTriangle(String filePath) {
		List<String> lines = null;
		try {
			lines = Files.readLines(new File(filePath),
					Charset.defaultCharset());
		} catch (IOException e) {
			System.err.println("Input data file not found!");
		}
		int[][] result = new int[lines.size()][];
		for (int i = 0; i < lines.size(); i++) {
			result[i] = new int[i + 1];
			StringTokenizer tokenizer = new StringTokenizer(lines.get(i));
			for (int j = 0; j < result[i].length; j++) {
				if (tokenizer.hasMoreTokens()) {
					result[i][j] = Integer.parseInt(tokenizer.nextToken());
				} else {
					System.err.println("Wrong input data file format!");
				}
			}
		}
		return result;
	}
}
